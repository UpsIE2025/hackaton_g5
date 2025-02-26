package com.g5.data_type_consumer.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
    @KafkaListener(topics = "price", groupId = "data-type-group")
    public void listenPrice(ConsumerRecord<String, String> record) {
        System.out.println("Topico 'price' recibe: " + record.value());
    }

	@KafkaListener(topics = "query", groupId = "data-type-group")
    public void listenQuery(ConsumerRecord<String, String> record) {
        System.out.println("Topico 'query' recibe: " + record.value());
    }

    @KafkaListener(topics = "purchase", groupId = "data-type-group")
    public void listenPurchase(ConsumerRecord<String, String> record) {
        System.out.println("Topico 'purchase' recibe: " + record.value());
    }

}
