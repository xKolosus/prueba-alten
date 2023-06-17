package com.inditex.trial.infrastructure.controller.response;

import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

  private BigInteger id;
  private String name;
  private String description;
}
