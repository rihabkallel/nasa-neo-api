package com.example.neo.application.service;

import com.example.neo.domain.CloseApproachData;
import com.example.neo.domain.Neo;
import com.example.neo.infrastructure.apiclient.NeoApiClient;
import com.example.neo.infrastructure.apiclient.NeoApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NeoService {

  private final NeoApiClient neoClient;

  public NeoService(NeoApiClient neoClient) {
    this.neoClient = neoClient;
  }

  public List<Neo> getNeos() {
    return convertToFlatNeos(neoClient.getNeos());
  }

  private static List<Neo> convertToFlatNeos(Map<String, List<NeoApiResponse.Neo>> neoMap) {
    List<Neo> neos = new ArrayList<>();

    for (Map.Entry<String, List<NeoApiResponse.Neo>> entry : neoMap.entrySet()) {
      String date = entry.getKey();
      List<NeoApiResponse.Neo> neoList = entry.getValue();

      for (NeoApiResponse.Neo neo : neoList) {
        Neo flatNeo = Neo.builder()
                .id(neo.getId())
                .neoReferenceId(neo.getNeoReferenceId())
                .name(neo.getName())
                .date(date)
                .absoluteMagnitude(neo.getAbsoluteMagnitudeH())
                .estimatedDiameterMin(neo.getEstimatedDiameter().getMeters().getEstimatedDiameterMin())
                .estimatedDiameterMax(neo.getEstimatedDiameter().getMeters().getEstimatedDiameterMax())
                .isPotentiallyHazardous(neo.isPotentiallyHazardousAsteroid())
                .closeApproachData(getCloseApproachData(neo.getCloseApproachData()))
                .build();

        neos.add(flatNeo);
      }
    }

    return neos;
  }

  private static List<CloseApproachData> getCloseApproachData(List<NeoApiResponse.CloseApproachData> closeApproachDataList) {
    List<CloseApproachData> data = new ArrayList<>();

    for (NeoApiResponse.CloseApproachData closeApproachData : closeApproachDataList) {
      CloseApproachData dataEntry = CloseApproachData.builder()
              .date(closeApproachData.getCloseApproachDate())
              .velocity(Double.parseDouble(closeApproachData.getRelativeVelocity().getKilometersPerSecond()))
              .missDistance(Double.parseDouble(closeApproachData.getMissDistance().getAstronomical()))
              .orbitingBody(closeApproachData.getOrbitingBody())
              .build();

      data.add(dataEntry);
    }

    return data;
  }
}
