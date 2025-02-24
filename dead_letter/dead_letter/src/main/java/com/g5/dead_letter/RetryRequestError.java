package com.g5.dead_letter;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Log4j2
@Component
public class RetryRequestError {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String deadLetterTopic;
    private final ApiService apiService;
    private final Queue<String> dlqMessages = new ConcurrentLinkedQueue<>();

    public RetryRequestError(KafkaTemplate<String, String> kafkaTemplate, @Value("${kafka.topic.dead-letter}") String deadLetterTopic, ApiService apiService) {
        this.kafkaTemplate = kafkaTemplate;
        this.deadLetterTopic = deadLetterTopic;
        this.apiService = apiService;
    }

    @KafkaListener(topics = "${kafka.topic.dead-letter}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenDeadLetter(String message) {
        dlqMessages.offer(message);
    }

    @Scheduled(fixedDelay = 10000)
    private void retryProcessing() {
        String message;
        if (!dlqMessages.isEmpty()) {
            log.info("REPROCESAMIENTO: ");
            while ((message = dlqMessages.poll()) != null) {
                try {
                    apiService.retryProcessMessage(message);
                } catch (Exception e) {
                    kafkaTemplate.send(deadLetterTopic, message);
                }
            }
        }
    }
}