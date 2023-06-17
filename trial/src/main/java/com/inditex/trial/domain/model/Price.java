package com.inditex.trial.domain.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {

  private Product product;
  private Brand brand;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private BigDecimal priceCalculated;
  private BigInteger priority;
  private BigInteger priceList;
  private String curr;
}
