package com.inditex.trial.domain.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceSearch {

  private LocalDateTime date;
  private BigInteger productId;
  private BigInteger brandId;
}
