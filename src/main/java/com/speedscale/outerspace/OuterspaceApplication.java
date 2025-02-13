package com.speedscale.outerspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OuterspaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OuterspaceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://api.spacexdata.com/v4")
                .build();
    }
} 