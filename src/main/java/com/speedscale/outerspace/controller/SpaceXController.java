package com.speedscale.outerspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speedscale.outerspace.model.Launch;
import com.speedscale.outerspace.model.Rocket;
import com.speedscale.outerspace.service.SpaceXService;

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
} 