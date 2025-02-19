package com.speedscale.outerspace.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.speedscale.outerspace.model.MathFact;

@Service
public class NumbersService {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://numbersapi.com";

    public NumbersService() {
        this(new RestTemplate());
    }

    NumbersService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MathFact getRandomMathFact() {
        return restTemplate.getForObject(baseUrl + "/random/math?json", MathFact.class);
    }
}