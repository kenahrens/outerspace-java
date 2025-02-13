package com.speedscale.outerspace.service;

import com.speedscale.outerspace.model.MathFact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumbersServiceTest {

    @Mock
    private WebClient webClient;
    
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;
    
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;
    
    @Mock
    private WebClient.ResponseSpec responseSpec;

    private NumbersService numbersService;

    @BeforeEach
    void setUp() {
        // We need to modify the NumbersService to accept a WebClient in the constructor for testing
        numbersService = new NumbersService(webClient);
    }

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