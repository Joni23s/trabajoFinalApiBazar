package com.joni23s.finalWorkApiMarket.entities;

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
    private List<ProductEntity> listProducts;

    @OneToOne
    @JoinColumn(name = "id_client")
    private ClientEntity client;

    public SaleEntity() { }

    public SaleEntity(LocalDate saleDate, Double total, List<ProductEntity> listProducts, ClientEntity client) {
        this.saleDate = saleDate;
        this.total = total;
        this.listProducts = listProducts;
        this.client = client;
    }

}
