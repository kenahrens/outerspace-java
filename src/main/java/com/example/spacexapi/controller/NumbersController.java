package com.example.spacexapi.controller;

import com.example.spacexapi.model.MathFact;
import com.example.spacexapi.service.SpaceXService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/numbers")
public class NumbersController {

    private final SpaceXService spaceXService;

    public NumbersController(SpaceXService spaceXService) {
        this.spaceXService = spaceXService;
    }

    @GetMapping("/math/random")
    public ResponseEntity<Mono<MathFact>> getRandomMathFact() {
        return ResponseEntity.ok(spaceXService.getRandomMathFact());
    }
} 