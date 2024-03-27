package com.joni23s.finalWorkApiMarket.services;

import com.joni23s.finalWorkApiMarket.entities.ClientEntity;
import com.joni23s.finalWorkApiMarket.entities.ProductEntity;
import com.joni23s.finalWorkApiMarket.entities.SaleEntity;
import com.joni23s.finalWorkApiMarket.models.SaleModel;
import com.joni23s.finalWorkApiMarket.repositories.ClientRepository;
import com.joni23s.finalWorkApiMarket.repositories.ProductRepository;
import com.joni23s.finalWorkApiMarket.repositories.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;


    public SaleEntity createSale(SaleModel newSaleModel) {
        ClientEntity newClient = clientRepository.findById(newSaleModel.getIdClient()).orElse(null);

        Iterable<Long> iterableProductCodes = new ArrayList<>(newSaleModel.getProductsCode());

        List<ProductEntity> newProducts = productRepository.findAllById(iterableProductCodes);
        Double costTotal = newProducts.stream().mapToDouble(ProductEntity::getCost).sum();

        LocalDate saleDate = LocalDate.now();

        SaleEntity newSale = new SaleEntity(saleDate, costTotal, newProducts, newClient);
        return saleRepository.save(newSale);
    }

    public SaleEntity getSale(Long id) {return saleRepository.findById(id).orElse(null); }

    public List<SaleEntity> getAllSales() {return saleRepository.findAll(); }

    public SaleEntity editSale(Long code, Long newCode, LocalDate newDate, Double newTotal, List<ProductEntity> newProducts, ClientEntity newClient) {
        SaleEntity sale = saleRepository.findById(code).orElse(null);

        sale.setSaleCode(newCode);
        sale.setSaleDate(newDate);
        sale.setTotal(newTotal);
        sale.setListProducts(newProducts);
        sale.setClient(newClient);

        saleRepository.save(sale);
        return sale;

    }

    public String deleteSale(Long id) {
        try {
            SaleEntity saleOld = saleRepository.findById(id).orElse(null);

            saleRepository.deleteById(id);

            return "Sale: " + saleOld.getSaleCode() + ". Eliminada";

        } catch (EntityNotFoundException e) {

            throw new RuntimeException("Error al buscar la sale", e);
        }
    }


}
