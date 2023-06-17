package com.inditex.trial.infrastructure.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inditex.trial.domain.model.Brand;
import com.inditex.trial.domain.model.Product;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResponse {

  private ProductResponse product;
  private BrandResponse brand;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private BigDecimal priceCalculated;
  @JsonIgnore private BigInteger priority;
  @JsonIgnore private BigInteger priceList;
  private String curr;
}
