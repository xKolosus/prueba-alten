package com.inditex.trial.application.service;

import com.inditex.trial.domain.dao.PriceDao;
import com.inditex.trial.domain.model.Price;
import com.inditex.trial.domain.model.PriceSearch;
import com.inditex.trial.domain.service.PriceService;
import jakarta.ws.rs.NotFoundException;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceDao priceDao;

  @Override
  public Price getPriceWithProductByFilters(PriceSearch search) {

    List<Price> pricesFound = priceDao.getPricesWithProductByFilters(search);

    return pricesFound.stream()
        .max(Comparator.comparing(Price::getPriority).thenComparing(Price::getPriceList))
        .orElseThrow(NotFoundException::new);
  }
}
