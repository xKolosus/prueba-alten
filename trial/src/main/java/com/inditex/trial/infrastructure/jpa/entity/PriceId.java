package com.inditex.trial.infrastructure.jpa.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PriceId {

  @ManyToOne private BrandEntity brand;

  @ManyToOne private ProductEntity product;

  private BigDecimal price;
}
