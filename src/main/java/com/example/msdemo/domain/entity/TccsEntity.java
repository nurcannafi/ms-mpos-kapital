package com.example.msdemo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TERMINAL_COMMISSION_CALCULATION_STRATEGY")
public class TccsEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PROPERTY_ID")
    private Long propertyId;
}
