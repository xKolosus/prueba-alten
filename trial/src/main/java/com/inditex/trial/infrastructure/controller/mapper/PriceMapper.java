package com.inditex.trial.infrastructure.controller.mapper;

import com.inditex.trial.domain.model.Price;
import com.inditex.trial.domain.model.PriceSearch;
import com.inditex.trial.infrastructure.controller.request.PriceRequest;
import com.inditex.trial.infrastructure.controller.response.PriceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceResponse toResponse(Price price);

    PriceSearch toSearch(PriceRequest request);
}
