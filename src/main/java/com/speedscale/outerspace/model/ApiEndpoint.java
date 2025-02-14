package com.speedscale.outerspace.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiEndpoint {
  private String path;
  private String method;
  private String description;
} 