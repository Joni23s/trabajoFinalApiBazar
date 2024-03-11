package com.joni23s.trabajoFinalApiBazar.service;

import com.joni23s.trabajoFinalApiBazar.entity.ProductEntity;
import com.joni23s.trabajoFinalApiBazar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> makeListProducts() {

        return productRepository.findAll();
    }

    public ProductEntity createProduct(ProductEntity productEntity) {

        return productRepository.save(productEntity);
    }
}
