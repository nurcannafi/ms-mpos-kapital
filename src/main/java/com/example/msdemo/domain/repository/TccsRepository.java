package com.example.msdemo.domain.repository;

import com.example.msdemo.domain.entity.TccsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TccsRepository extends JpaRepository<TccsEntity, Long> {

    List<TccsEntity> findByProductTypeAndPropertyIdIn(String productType, List<Integer> propertyIds);
}
