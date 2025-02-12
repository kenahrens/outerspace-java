package com.example.spacexapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpacexApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpacexApiApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://api.spacexdata.com/v4")
                .build();
    }
} 