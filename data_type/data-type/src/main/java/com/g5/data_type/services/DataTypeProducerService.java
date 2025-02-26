package com.g5.data_type.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataTypeProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public DataTypeProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.printf("Topic: %1$s. Message: %2$s%n", topic, message);
    }
	
}
