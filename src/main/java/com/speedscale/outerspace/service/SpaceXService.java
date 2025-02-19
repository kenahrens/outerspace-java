package com.speedscale.outerspace.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.speedscale.outerspace.model.Launch;
import com.speedscale.outerspace.model.Rocket;

@Service
public class SpaceXService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "https://api.spacexdata.com/v4";

    public SpaceXService() {
        this(new RestTemplate());
    }

    SpaceXService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Launch> getAllLaunches() {
        Launch[] launches = restTemplate.getForObject(baseUrl + "/launches", Launch[].class);
        return Arrays.asList(launches);
    }

    public Launch getLaunchById(String id) {
        return restTemplate.getForObject(baseUrl + "/launches/{id}", Launch.class, id);
    }

    public List<Rocket> getAllRockets() {
        Rocket[] rockets = restTemplate.getForObject(baseUrl + "/rockets", Rocket[].class);
        return Arrays.asList(rockets);
    }

    public Rocket getRocketById(String id) {
        return restTemplate.getForObject(baseUrl + "/rockets/{id}", Rocket.class, id);
    }
} 