package com.example.neo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CloseApproachData {
  private String date;
  private double velocity; // kilometers per second
  private double missDistance; // astronomical units
  private String orbitingBody;
}
