package com.example.msdemo.domain.repository;

import com.example.msdemo.domain.entity.TariffOperationByMcgEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TariffOperationByMcgRepository extends JpaRepository<TariffOperationByMcgEntity, Long> {

    List<TariffOperationByMcgEntity> findByTccsIdInAndMcgId(List<Long> tccsIds, Long mcgId);
}
