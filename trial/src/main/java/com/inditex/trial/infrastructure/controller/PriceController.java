package com.inditex.trial.infrastructure.controller;

import com.inditex.trial.domain.service.PriceService;
import com.inditex.trial.infrastructure.controller.mapper.PriceMapper;
import com.inditex.trial.infrastructure.controller.request.PriceRequest;
import com.inditex.trial.infrastructure.controller.response.PriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {

  private final PriceService service;
  private final PriceMapper mapper;

  @PostMapping("/find-filtered")
  public ResponseEntity<PriceResponse> getPriceWithInfoFiltered(@RequestBody PriceRequest request) {
    return ResponseEntity.ok(
        mapper.toResponse(service.getPriceWithProductByFilters(mapper.toSearch(request))));
  }
}
