package com.inditex.trial.domain.model;

import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

  private BigInteger id;
  private String name;
  private String description;
}
