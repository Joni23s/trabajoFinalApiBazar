package com.joni23s.finalWorkApiMarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter @Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_code")
    private Long productCode;

    private String name;

    private String brand;

    private Double cost;

    private Double stock;


    public ProductEntity() { }

    public ProductEntity(Long productCode, String name, String brand, Double cost, Double stock) {
        this.productCode = productCode;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
    }
}
