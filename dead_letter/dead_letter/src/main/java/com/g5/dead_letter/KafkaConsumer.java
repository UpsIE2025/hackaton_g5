package com.g5.dead_letter;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaConsumer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String deadLetterTopic;

    private final ApiService apiService;

    public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate, @Value("${kafka.topic.dead-letter}") String deadLetterTopic, ApiService apiService) {
        this.kafkaTemplate = kafkaTemplate;
        this.deadLetterTopic = deadLetterTopic;
        this.apiService = apiService;
    }

    @KafkaListener(topics = "${kafka.topic.main}", groupId = "${spring.kafka.consumer.group-id}")
    public void processMessage(String message) {
        try {
            apiService.processMessage(message);
            log.info("Procesamiento exitoso: {}", message);
        } catch (Exception e) {
            kafkaTemplate.send(deadLetterTopic, message);
            log.error("Error al procesar el mensaje, enviando al Dead Letter Topic");
        }
    }
}
