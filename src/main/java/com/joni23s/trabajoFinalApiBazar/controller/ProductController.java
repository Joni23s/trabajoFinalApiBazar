package com.joni23s.trabajoFinalApiBazar.controller;

import com.joni23s.trabajoFinalApiBazar.entity.ProductEntity;
import com.joni23s.trabajoFinalApiBazar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joni23s/apibazar/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get/products")
    public List<ProductEntity> getProducts() {

        return productService.makeListProducts();
    }

    @PostMapping("/post/product")
    public ProductEntity postProduct(@RequestBody ProductEntity productEntity) {

        return productService.createProduct(productEntity);
    }
}
