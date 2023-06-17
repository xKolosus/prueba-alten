package com.inditex.trial.domain.dao;

import com.inditex.trial.domain.model.Price;
import com.inditex.trial.domain.model.PriceSearch;
import java.util.List;

public interface PriceDao {

  List<Price> getPricesWithProductByFilters(PriceSearch search);
}
