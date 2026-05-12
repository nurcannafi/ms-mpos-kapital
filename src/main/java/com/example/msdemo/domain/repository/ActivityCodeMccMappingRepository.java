package com.example.msdemo.domain.repository;

import com.example.msdemo.domain.entity.ActivityCodeMccMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityCodeMccMappingRepository extends JpaRepository<ActivityCodeMccMappingEntity, String> {

    Optional<ActivityCodeMccMappingEntity> findByActivityCode(String activityCode);
}
