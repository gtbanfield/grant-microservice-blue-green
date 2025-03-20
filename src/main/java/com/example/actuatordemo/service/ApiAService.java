package com.example.actuatordemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiAService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public String getDataFromApiB() {
        String url = "http://localhost:8081/api/b/data"; // Replace with API B's endpoint
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

