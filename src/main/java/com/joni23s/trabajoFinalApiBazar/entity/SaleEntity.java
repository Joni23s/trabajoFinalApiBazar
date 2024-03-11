package com.joni23s.trabajoFinalApiBazar.entity;

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

    @ManyToOne
    @JoinColumn(name = "id_products")
    private List<ProductEntity> listProducts;

    @OneToOne
    private ClientEntity aCustomer;

}
