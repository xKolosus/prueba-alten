package com.inditex.trial.infrastructure.controller.request;

import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceRequest {

  private String date;
  private BigInteger productId;
  private BigInteger brandId;
}
