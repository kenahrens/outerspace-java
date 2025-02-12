package com.example.spacexapi.controller;

import com.example.spacexapi.model.Launch;
import com.example.spacexapi.model.Rocket;
import com.example.spacexapi.model.MathFact;
import com.example.spacexapi.service.SpaceXService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/spacex")
public class SpaceXController {

    private final SpaceXService spaceXService;

    public SpaceXController(SpaceXService spaceXService) {
        this.spaceXService = spaceXService;
    }

    @GetMapping("/launches")
    public ResponseEntity<Flux<Launch>> getAllLaunches() {
        return ResponseEntity.ok(spaceXService.getAllLaunches());
    }

    @GetMapping("/launches/{id}")
    public ResponseEntity<Mono<Launch>> getLaunchById(@PathVariable String id) {
        return ResponseEntity.ok(spaceXService.getLaunchById(id));
    }

    @GetMapping("/rockets")
    public ResponseEntity<Flux<Rocket>> getAllRockets() {
        return ResponseEntity.ok(spaceXService.getAllRockets());
    }

    @GetMapping("/rockets/{id}")
    public ResponseEntity<Mono<Rocket>> getRocketById(@PathVariable String id) {
        return ResponseEntity.ok(spaceXService.getRocketById(id));
    }

    @GetMapping("/math/random")
    public ResponseEntity<Mono<MathFact>> getRandomMathFact() {
        return ResponseEntity.ok(spaceXService.getRandomMathFact());
    }
} 