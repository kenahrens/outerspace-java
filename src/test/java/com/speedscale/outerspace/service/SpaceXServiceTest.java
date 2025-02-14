package com.speedscale.outerspace.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.speedscale.outerspace.model.Launch;
import com.speedscale.outerspace.model.Rocket;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class SpaceXServiceTest {

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

  private SpaceXService spaceXService;
  
  @BeforeEach
  public void setUp() {
    spaceXService = new SpaceXService(webClient);
  }

  @SuppressWarnings("unchecked")
  @Test
  void getAllLaunches_ShouldReturnLaunches() {
    // Arrange
    Launch launch = new Launch();
    launch.setId("1");
    launch.setName("Mission 1");

    when(webClient.get()).thenReturn(requestHeadersUriSpec);
    when(requestHeadersUriSpec.uri("/launches")).thenReturn(requestHeadersSpec);
    when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    when(responseSpec.bodyToFlux(Launch.class)).thenReturn(Flux.just(launch));

    // Act & Assert
    StepVerifier.create(spaceXService.getAllLaunches())
      .expectNext(launch)
      .verifyComplete();
  }

  
  @SuppressWarnings("unchecked")
  @Test
  void getLaunchById_ShouldReturnLaunch() {
    // Arrange
    Launch launch = new Launch();
    launch.setId("1");
    launch.setName("Mission 1");

    when(webClient.get()).thenReturn(requestHeadersUriSpec);
    when(requestHeadersUriSpec.uri("/launches/{id}", "1")).thenReturn(requestHeadersSpec);
    when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    when(responseSpec.bodyToMono(Launch.class)).thenReturn(Mono.just(launch));

    // Act & Assert
    StepVerifier.create(spaceXService.getLaunchById("1"))
      .expectNext(launch)
      .verifyComplete();
  }

  @SuppressWarnings("unchecked")
  @Test
  void getAllRockets_ShouldReturnRockets() {
    // Arrange
    Rocket rocket = new Rocket();
    rocket.setId("1");
    rocket.setName("Falcon 9");

    when(webClient.get()).thenReturn(requestHeadersUriSpec);
    when(requestHeadersUriSpec.uri("/rockets")).thenReturn(requestHeadersSpec);
    when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    when(responseSpec.bodyToFlux(Rocket.class)).thenReturn(Flux.just(rocket));

    // Act & Assert
    StepVerifier.create(spaceXService.getAllRockets())
      .expectNext(rocket)
      .verifyComplete();
  }

  @SuppressWarnings("unchecked")
  @Test
  void getRocketById_ShouldReturnRocket() {
    // Arrange
    Rocket rocket = new Rocket();
    rocket.setId("1");
    rocket.setName("Falcon 9");

    when(webClient.get()).thenReturn(requestHeadersUriSpec);
    when(requestHeadersUriSpec.uri("/rockets/{id}", "1")).thenReturn(requestHeadersSpec);
    when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    when(responseSpec.bodyToMono(Rocket.class)).thenReturn(Mono.just(rocket));

    // Act & Assert
    StepVerifier.create(spaceXService.getRocketById("1"))
      .expectNext(rocket)
      .verifyComplete();
  }
} 