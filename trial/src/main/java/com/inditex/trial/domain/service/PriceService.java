package com.inditex.trial.domain.service;

import com.inditex.trial.domain.model.Price;
import com.inditex.trial.domain.model.PriceSearch;

public interface PriceService {

    Price getPriceWithProductByFilters(PriceSearch search);
}
