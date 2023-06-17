package com.inditex.trial.infrastructure.jpa.mapper;

import com.inditex.trial.domain.model.Price;
import com.inditex.trial.infrastructure.jpa.entity.PriceEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

  @Mapping(source = "id.price", target = "priceCalculated")
  @Mapping(source = "id.brand", target = "brand")
  @Mapping(source = "id.product", target = "product")
  Price toDomain(PriceEntity entity);

  List<Price> toDomain(List<PriceEntity> entity);
}
