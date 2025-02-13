package com.example.spacexapi.service;

import com.example.spacexapi.model.MathFact;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NumbersService {
    private final WebClient numbersApiClient;

    public NumbersService() {
        this(WebClient.builder()
                .baseUrl("http://numbersapi.com")
                .build());
    }

    // Constructor for testing
    NumbersService(WebClient webClient) {
        this.numbersApiClient = webClient;
    }

    public Mono<MathFact> getRandomMathFact() {
        return numbersApiClient.get()
                .uri("/random/math?json")
                .retrieve()
                .bodyToMono(MathFact.class);
    }
} 