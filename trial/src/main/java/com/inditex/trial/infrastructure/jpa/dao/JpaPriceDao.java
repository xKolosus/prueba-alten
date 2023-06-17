package com.inditex.trial.infrastructure.jpa.dao;

import com.inditex.trial.domain.dao.PriceDao;
import com.inditex.trial.domain.model.Price;
import com.inditex.trial.domain.model.PriceCriteria;
import com.inditex.trial.domain.model.PriceSearch;
import com.inditex.trial.infrastructure.jpa.mapper.PriceEntityMapper;
import com.inditex.trial.infrastructure.jpa.repository.PriceJpaRepository;
import com.inditex.trial.infrastructure.jpa.repository.specification.PriceSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaPriceDao implements PriceDao {

  private final PriceJpaRepository priceJpaRepository;
  private final PriceEntityMapper mapper;

  @Override
  public List<Price> getPricesWithProductByFilters(PriceSearch search) {
    return mapper.toDomain(
        priceJpaRepository.findAll(PriceSpecification.search(new PriceCriteria(search))));
  }
}
