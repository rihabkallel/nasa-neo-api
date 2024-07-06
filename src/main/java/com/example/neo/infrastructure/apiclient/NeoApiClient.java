package com.example.neo.infrastructure.apiclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class NeoApiClient {

  private final RestTemplate restTemplate;
  private final String apiKey;
  private final String url;

  public NeoApiClient(RestTemplate restTemplate, @Value("${nasa.api.key}") String apiKey, @Value("${nasa.api.url}") String url) {
    this.restTemplate = restTemplate;
    this.apiKey = apiKey;
    this.url = url;
  }

  public Map<String, List<NeoApiResponse.Neo>> getNeos() {
    String apiUrl = String.format("%s?api_key=%s", url, apiKey);
    return Objects.requireNonNull(restTemplate.getForObject(apiUrl, NeoApiResponse.class)).getNearEarthObjects();
  }
}