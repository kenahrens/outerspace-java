package com.speedscale.outerspace.controller;

import com.speedscale.outerspace.model.ApiEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiDocController {

    @GetMapping("/")
    public ResponseEntity<List<ApiEndpoint>> getAvailableEndpoints() {
        List<ApiEndpoint> endpoints = List.of(
            ApiEndpoint.builder()
                .path("/api/spacex/launches")
                .method("GET")
                .description("Get a list of all SpaceX launches")
                .build(),
            ApiEndpoint.builder()
                .path("/api/spacex/launches/{id}")
                .method("GET")
                .description("Get details about a specific SpaceX launch")
                .build(),
            ApiEndpoint.builder()
                .path("/api/spacex/rockets")
                .method("GET")
                .description("Get a list of all SpaceX rockets")
                .build(),
            ApiEndpoint.builder()
                .path("/api/spacex/rockets/{id}")
                .method("GET")
                .description("Get details about a specific SpaceX rocket")
                .build(),
            ApiEndpoint.builder()
                .path("/api/numbers/math/random")
                .method("GET")
                .description("Get a random math fact")
                .build()
        );
        
        return ResponseEntity.ok(endpoints);
    }
} 