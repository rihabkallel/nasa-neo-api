package com.example.neo.application.api;

import com.example.neo.application.service.NeoService;
import com.example.neo.domain.Neo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/neo")
public class NeoController {

  private final NeoService neoService;

  public NeoController(NeoService neoService) {
    this.neoService = neoService;
  }

  @GetMapping("/search")
  public List<Neo> searchNeos() {
    return neoService.getNeos();
  }
}