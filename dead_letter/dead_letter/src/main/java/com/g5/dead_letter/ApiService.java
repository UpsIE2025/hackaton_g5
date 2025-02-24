package com.g5.dead_letter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService() {
        this.restTemplate = new RestTemplate();
    }

    public void processMessage(String message) {
        try {
            String apiResponse = restTemplate.getForObject("https://api.ejemplo.com/reintentar?mensaje=" + message, String.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void retryProcessMessage(String message) {
        log.info("Procesamiento exitoso: " + message);
    }
}