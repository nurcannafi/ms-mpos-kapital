package com.example.msdemo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TARIFF_OPERATION_BY_MCG")
public class TariffOperationByMcgEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TCCS_ID")
    private Long tccsId;

    @Column(name = "MCG_ID")
    private Long mcgId;

    @Column(name = "OPERATION_CODE")
    private String operationCode;
}
