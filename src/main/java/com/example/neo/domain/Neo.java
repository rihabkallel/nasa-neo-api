package com.example.neo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Neo {
  private String id;
  private String neoReferenceId;
  private String name;
  private String date;
  private double absoluteMagnitude;
  private double estimatedDiameterMin; // in meters
  private double estimatedDiameterMax; // in meters
  private boolean isPotentiallyHazardous;
  private List<CloseApproachData> closeApproachData;

}
