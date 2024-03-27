package com.joni23s.finalWorkApiMarket.models;

import com.joni23s.finalWorkApiMarket.entities.ClientEntity;
import com.joni23s.finalWorkApiMarket.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaleModel {
    private Long idClient;
    private List<Long> productsCode;

    public SaleModel() {
    }

    public SaleModel(Long idClient, List<Long> productsCode) {
        this.idClient = idClient;
        this.productsCode = productsCode;
    }
}
