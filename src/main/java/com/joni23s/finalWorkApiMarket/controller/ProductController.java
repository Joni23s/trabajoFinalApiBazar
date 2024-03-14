package com.joni23s.finalWorkApiMarket.controller;

import com.joni23s.finalWorkApiMarket.entity.ProductEntity;
import com.joni23s.finalWorkApiMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Funciona
    @PostMapping("/post")
    public ProductEntity postProduct(@RequestBody ProductEntity newProduct) {
        return productService.createProduct(newProduct);
    }

    //Funciona
    @GetMapping("/get/{productCode}")
    public ProductEntity getProduct(@PathVariable Long productCode) { return productService.getProduct(productCode); }

    //Funciona
    @GetMapping("/getProducts")
    public List<ProductEntity> getProducts() { return productService.getAllProducts(); }

    @PutMapping("/update/{code}")
    public ProductEntity updateProduct(@PathVariable Long code,
                                       @RequestParam(required = false, name = "productCode") Long newCode,
                                       @RequestParam(required = false, name = "name") String newName,
                                       @RequestParam(required = false, name = "brand") String newBrand,
                                       @RequestParam(required = false, name = "cost") Double newCost,
                                       @RequestParam(required = false, name = "stock") Double newStock) {
        return productService.editProduct(code, newCode, newName, newBrand, newCost, newStock);
    }

    @DeleteMapping("/delete/{productCode}")
    public String deleteProductForId(@PathVariable Long productCode) { return  productService.deleteProduct(productCode); }


}
