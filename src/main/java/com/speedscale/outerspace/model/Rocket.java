package com.speedscale.outerspace.model;

import lombok.Data;

@Data
public class Rocket {
    private String id;
    private String name;
    private String description;
    private String type;
    private Boolean active;
    private Integer stages;
    private Integer boosters;
    private Double cost_per_launch;
    private Double success_rate_pct;
    private String first_flight;
    private String country;
    private String company;
    private Double height_meters;
    private Double diameter_meters;
    private Double mass_kg;
} 