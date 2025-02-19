package com.speedscale.outerspace.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.speedscale.outerspace.model.Launch;
import com.speedscale.outerspace.model.Rocket;

@ExtendWith(MockitoExtension.class)
class SpaceXServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private SpaceXService spaceXService;

    @BeforeEach
    void setUp() {
        spaceXService = new SpaceXService(restTemplate);
    }

    @Test
    void getAllLaunches_ShouldReturnLaunches() {
        // Arrange
        Launch[] launches = {
            createLaunch("1", "Mission 1"),
            createLaunch("2", "Mission 2")
        };
        when(restTemplate.getForObject(anyString(), eq(Launch[].class))).thenReturn(launches);

        // Act
        var result = spaceXService.getAllLaunches();

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo("1");
        assertThat(result.get(0).getName()).isEqualTo("Mission 1");
    }

    @Test
    void getLaunchById_ShouldReturnLaunch() {
        // Arrange
        Launch launch = createLaunch("1", "Mission 1");
        when(restTemplate.getForObject(anyString(), eq(Launch.class), anyString())).thenReturn(launch);

        // Act
        var result = spaceXService.getLaunchById("1");

        // Assert
        assertThat(result.getId()).isEqualTo("1");
        assertThat(result.getName()).isEqualTo("Mission 1");
    }

    @Test
    void getAllRockets_ShouldReturnRockets() {
        // Arrange
        Rocket[] rockets = {
            createRocket("1", "Falcon 1"),
            createRocket("2", "Falcon 9")
        };
        when(restTemplate.getForObject(anyString(), eq(Rocket[].class))).thenReturn(rockets);

        // Act
        var result = spaceXService.getAllRockets();

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo("1");
        assertThat(result.get(0).getName()).isEqualTo("Falcon 1");
    }

    @Test
    void getRocketById_ShouldReturnRocket() {
        // Arrange
        Rocket rocket = createRocket("1", "Falcon 1");
        when(restTemplate.getForObject(anyString(), eq(Rocket.class), anyString())).thenReturn(rocket);

        // Act
        var result = spaceXService.getRocketById("1");

        // Assert
        assertThat(result.getId()).isEqualTo("1");
        assertThat(result.getName()).isEqualTo("Falcon 1");
    }

    private Launch createLaunch(String id, String name) {
        Launch launch = new Launch();
        launch.setId(id);
        launch.setName(name);
        return launch;
    }

    private Rocket createRocket(String id, String name) {
        Rocket rocket = new Rocket();
        rocket.setId(id);
        rocket.setName(name);
        return rocket;
    }
} 