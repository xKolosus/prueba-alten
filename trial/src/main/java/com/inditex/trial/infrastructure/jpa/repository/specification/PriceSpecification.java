package com.inditex.trial.infrastructure.jpa.repository.specification;

import com.inditex.trial.domain.model.PriceCriteria;
import com.inditex.trial.infrastructure.jpa.entity.BrandEntity;
import com.inditex.trial.infrastructure.jpa.entity.PriceEntity;
import com.inditex.trial.infrastructure.jpa.entity.ProductEntity;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class PriceSpecification {

  private PriceSpecification() {}

  public static Specification<PriceEntity> search(PriceCriteria criteria) {

    return new Specification<>() {

      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(
          Root<PriceEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getDate() != null) {
          predicates.add(
              criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), criteria.getDate()));
          predicates.add(
              criteriaBuilder.greaterThanOrEqualTo(root.get("endDate"), criteria.getDate()));
        }

        Join<ProductEntity, PriceEntity> joinProduct = root.join("id").join("product");
        if (criteria.getProductId() != null) {
          predicates.add(criteriaBuilder.equal(joinProduct.get("id"), criteria.getProductId()));
        }

        Join<BrandEntity, PriceEntity> joinBrand = root.join("id").join("brand");
        if (criteria.getBrandId() != null) {
          predicates.add(criteriaBuilder.equal(joinBrand.get("id"), criteria.getBrandId()));
        }

        return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
      }
    };
  }
}
