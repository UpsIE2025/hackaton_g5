package com.g5.data_type.controllers;

import org.springframework.web.bind.annotation.*;

import com.g5.data_type.services.DataTypeProducerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/data-type")
public class DataTypeController {

    private final DataTypeProducerService producerService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        String[] availableTopics = {"query", "price", "purchase"};

        boolean topicIsFound = java.util.Arrays.asList(availableTopics).contains(topic);

        if (topicIsFound) {
            producerService.sendMessage(topic, message);
            return String.format("Mensaje enviado al topico %1$s!", topic);
        } else {
            return String.format("El topico %1$s no existe!", topic);
        }
    }

}
