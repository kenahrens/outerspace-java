package com.speedscale.outerspace.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.speedscale.outerspace.model.MathFact;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NumbersServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private NumbersService numbersService;

    @BeforeEach
    void setUp() {
        numbersService = new NumbersService(restTemplate);
    }

    @Test
    void getRandomMathFact_ShouldReturnMathFact() {
        // Arrange
        MathFact mathFact = new MathFact();
        mathFact.setText("42 is the answer to life, the universe, and everything");
        mathFact.setNumber(42);
        mathFact.setFound(true);
        mathFact.setType("math");

        when(restTemplate.getForObject(anyString(), eq(MathFact.class))).thenReturn(mathFact);

        // Act
        MathFact result = numbersService.getRandomMathFact();

        // Assert
        assertThat(result).isEqualTo(mathFact);
    }
}