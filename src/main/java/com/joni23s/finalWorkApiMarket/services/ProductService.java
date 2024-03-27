package com.joni23s.finalWorkApiMarket.services;

import com.joni23s.finalWorkApiMarket.entities.ProductEntity;
import com.joni23s.finalWorkApiMarket.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity productEntity) { return productRepository.save(productEntity); }

    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductEntity> getAllProducts() { return productRepository.findAll(); }

    public ProductEntity editProduct(Long code, Long newCode, String newName, String newBrand, Double newCost, Double newStock) {

        ProductEntity product = productRepository.findById(code).orElse(null);

        product.setProductCode(newCode);
        product.setName(newName);
        product.setBrand(newBrand);
        product.setCost(newCost);
        product.setStock(newStock);

        productRepository.save(product);
        return product;
    }

    public String deleteProduct(Long id) {
        try {
            ProductEntity productOld = productRepository.findById(id).orElse(null);

            productRepository.deleteById(id);

            return "Producto: " + productOld.getName() + ", " + productOld.getBrand() + ". Eliminado";
        } catch (EntityNotFoundException e) {

            throw new RuntimeException("Error al buscar el producto", e);
        }
    }


}
