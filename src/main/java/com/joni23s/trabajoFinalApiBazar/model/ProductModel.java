package com.joni23s.trabajoFinalApiBazar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ProductModel {

    private Long productCode;

    private String name;

    private String brand;

    private Double cost;


    public ProductModel() { }

    public ProductModel(Long productCode, String name, String brand, Double cost) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
    }
}
