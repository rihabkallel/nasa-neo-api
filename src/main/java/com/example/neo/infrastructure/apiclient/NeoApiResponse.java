package com.example.neo.infrastructure.apiclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NeoApiResponse {
  @JsonProperty("near_earth_objects")
  private Map<String, List<Neo>> nearEarthObjects;

  @Data
  public static class Neo {
    @JsonProperty("links")
    private Links links;
    @JsonProperty("id")
    private String id;
    @JsonProperty("neo_reference_id")
    private String neoReferenceId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nasa_jpl_url")
    private String nasaJplUrl;
    @JsonProperty("absolute_magnitude_h")
    private double absoluteMagnitudeH;
    @JsonProperty("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;
    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;
    @JsonProperty("close_approach_data")
    private List<CloseApproachData> closeApproachData;
    @JsonProperty("is_sentry_object")
    private boolean isSentryObject;
  }

  @Data
  public static class Links {
    @JsonProperty("self")
    private String self;
  }

  @Data
  public static class EstimatedDiameter {
    @JsonProperty("kilometers")
    private DiameterUnit kilometers;
    @JsonProperty("meters")
    private DiameterUnit meters;
    @JsonProperty("miles")
    private DiameterUnit miles;
    @JsonProperty("feet")
    private DiameterUnit feet;
  }

  @Data
  public static class DiameterUnit {
    @JsonProperty("estimated_diameter_min")
    private double estimatedDiameterMin;
    @JsonProperty("estimated_diameter_max")
    private double estimatedDiameterMax;
  }

  @Data
  public static class CloseApproachData {
    @JsonProperty("close_approach_date")
    private String closeApproachDate;
    @JsonProperty("close_approach_date_full")
    private String closeApproachDateFull;
    @JsonProperty("epoch_date_close_approach")
    private long epochDateCloseApproach;
    @JsonProperty("relative_velocity")
    private RelativeVelocity relativeVelocity;
    @JsonProperty("miss_distance")
    private MissDistance missDistance;
    @JsonProperty("orbiting_body")
    private String orbitingBody;
  }

  @Data
  public static class RelativeVelocity {
    @JsonProperty("kilometers_per_second")
    private String kilometersPerSecond;
    @JsonProperty("kilometers_per_hour")
    private String kilometersPerHour;
    @JsonProperty("miles_per_hour")
    private String milesPerHour;
  }

  @Data
  public static class MissDistance {
    @JsonProperty("astronomical")
    private String astronomical;
    @JsonProperty("lunar")
    private String lunar;
    @JsonProperty("kilometers")
    private String kilometers;
    @JsonProperty("miles")
    private String miles;
  }
}
