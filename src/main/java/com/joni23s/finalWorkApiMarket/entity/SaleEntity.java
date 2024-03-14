package com.joni23s.finalWorkApiMarket.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter @Setter
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sale_code")
    private Long saleCode;

    @Column(name = "sale_date")
    private LocalDate saleDate;

    private Double total;

    @OneToMany
//    @JoinColumn(name = "Products_product_code")
    private List<ProductEntity> listProducts;

    @OneToOne
    private ClientEntity aCustomer;

}
