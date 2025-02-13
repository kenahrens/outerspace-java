package com.speedscale.outerspace.model;

import lombok.Data;

@Data
public class Launch {
    private String id;
    private String name;
    private String details;
    private String date_utc;
    private Boolean success;
} 