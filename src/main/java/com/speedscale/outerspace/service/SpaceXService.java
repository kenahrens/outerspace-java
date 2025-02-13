package com.speedscale.outerspace.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.speedscale.outerspace.model.Launch;
import com.speedscale.outerspace.model.Rocket;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SpaceXService {

    private final WebClient webClient;

    public SpaceXService(WebClient webClient) {
        this.webClient = webClient;
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
} 