package com.speedscale.outerspace.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.speedscale.outerspace.model.MathFact;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class NumbersServiceTest {

  @Mock
  private WebClient webClient;
  
  @Mock
  @SuppressWarnings("rawtypes")
  private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;
  
  @Mock
  @SuppressWarnings("rawtypes")
  private WebClient.RequestHeadersSpec requestHeadersSpec;
  
  @Mock
  private WebClient.ResponseSpec responseSpec;

  private NumbersService numbersService;

  @BeforeEach
  public void setUp() {
    numbersService = new NumbersService(webClient);
  }

  @SuppressWarnings("unchecked")
  @Test
  void getRandomMathFact_ShouldReturnMathFact() {
    // Arrange
    MathFact mathFact = new MathFact();
    mathFact.setText("42 is the answer to life, the universe, and everything");
    mathFact.setNumber(42);
    mathFact.setFound(true);
    mathFact.setType("math");

    when(webClient.get()).thenReturn(requestHeadersUriSpec);
    when(requestHeadersUriSpec.uri("/random/math?json")).thenReturn(requestHeadersSpec);
    when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    when(responseSpec.bodyToMono(MathFact.class)).thenReturn(Mono.just(mathFact));

    // Act & Assert
    StepVerifier.create(numbersService.getRandomMathFact())
      .expectNext(mathFact)
      .verifyComplete();
    }
} 