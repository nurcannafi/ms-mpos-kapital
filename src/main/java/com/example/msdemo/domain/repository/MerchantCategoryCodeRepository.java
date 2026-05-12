package com.example.msdemo.domain.repository;

import com.example.msdemo.domain.entity.MerchantCategoryCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantCategoryCodeRepository extends JpaRepository<MerchantCategoryCodeEntity, Integer> {

    Optional<MerchantCategoryCodeEntity> findByCode(Long mcc);
}
