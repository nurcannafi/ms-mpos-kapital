package com.example.msdemo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MERCHANT_CATEGORY_CODE")
public class MerchantCategoryCodeEntity {

    @Id
    @Column(name = "CODE")
    private Long code;

    @Column(name = "MCG_ID")
    private Long mcgId;
}