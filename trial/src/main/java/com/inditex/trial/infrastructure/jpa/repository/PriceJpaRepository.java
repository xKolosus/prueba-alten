package com.inditex.trial.infrastructure.jpa.repository;

import com.inditex.trial.infrastructure.jpa.entity.PriceEntity;
import com.inditex.trial.infrastructure.jpa.entity.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository
    extends JpaRepository<PriceEntity, PriceId>, JpaSpecificationExecutor<PriceEntity> {}
