package com.speedscale.outerspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speedscale.outerspace.model.MathFact;
import com.speedscale.outerspace.service.NumbersService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/numbers")
public class NumbersController {

  private final NumbersService numbersService;

  public NumbersController(NumbersService numbersService) {
    this.numbersService = numbersService;
  }

  @GetMapping("/math/random")
  public ResponseEntity<Mono<MathFact>> getRandomMathFact() {
  return ResponseEntity.ok(numbersService.getRandomMathFact());
  }
} 