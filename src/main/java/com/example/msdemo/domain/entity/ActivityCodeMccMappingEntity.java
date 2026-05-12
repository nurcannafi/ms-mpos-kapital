package com.example.msdemo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACTIVITY_CODE_MCC_MAPPING")
public class ActivityCodeMccMappingEntity {

    @Id
    @Column(name = "ACTIVITY_CODE")
    private String activityCode;

    @Column(name = "MCC")
    private Long mcc;
}
