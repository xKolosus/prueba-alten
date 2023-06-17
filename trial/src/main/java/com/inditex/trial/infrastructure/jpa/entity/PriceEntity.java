package com.inditex.trial.infrastructure.jpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Getter
@Setter
public class PriceEntity {

  @EmbeddedId private PriceId id;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private BigInteger priceList;

  private BigInteger priority;

  private String curr;
}
