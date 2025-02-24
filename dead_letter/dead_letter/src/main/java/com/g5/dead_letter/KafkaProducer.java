package com.g5.dead_letter;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, @Value("${kafka.topic.main}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
        log.info("-------Producer:  " + message);
    }
}
