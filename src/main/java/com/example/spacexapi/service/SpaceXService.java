package com.example.spacexapi.service;

import com.example.spacexapi.model.Launch;
import com.example.spacexapi.model.Rocket;
import com.example.spacexapi.model.MathFact;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SpaceXService {

    private final WebClient webClient;
    private final WebClient numbersApiClient;

    public SpaceXService(WebClient webClient) {
        this.webClient = webClient;
        this.numbersApiClient = WebClient.builder()
                .baseUrl("http://numbersapi.com")
                .build();
    }

    public Flux<Launch> getAllLaunches() {
        return webClient.get()
                .uri("/launches")
                .retrieve()
                .bodyToFlux(Launch.class);
    }

    public Mono<Launch> getLaunchById(String id) {
        return webClient.get()
                .uri("/launches/{id}", id)
                .retrieve()
                .bodyToMono(Launch.class);
    }

    public Flux<Rocket> getAllRockets() {
        return webClient.get()
                .uri("/rockets")
                .retrieve()
                .bodyToFlux(Rocket.class);
    }

    public Mono<Rocket> getRocketById(String id) {
        return webClient.get()
                .uri("/rockets/{id}", id)
                .retrieve()
                .bodyToMono(Rocket.class);
    }

    public Mono<MathFact> getRandomMathFact() {
        return numbersApiClient.get()
                .uri("/random/math?json")
                .retrieve()
                .bodyToMono(MathFact.class);
    }
} 