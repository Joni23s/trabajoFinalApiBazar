package com.joni23s.finalWorkApiMarket.controllers;

import com.joni23s.finalWorkApiMarket.entities.ProductEntity;
import com.joni23s.finalWorkApiMarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Funciona
    /* Crea un nuevo producto a traves de formato JSON. Con todos los datos de ProductEntity.
    * Excepto el Id (productCode) que lo crea automaticamente la BD*/
    @PostMapping("/post")
    public ProductEntity postProduct(@RequestBody ProductEntity newProduct) {
        return productService.createProduct(newProduct);
    }

    //Funciona
    /*Trae un Producto con toda su información, a traves de una solicitud GET en una URL
     acompañada con el codigo del producto
     */
    @GetMapping("/get/{productCode}")
    public ProductEntity getProduct(@PathVariable Long productCode) { return productService.getProduct(productCode); }

    //Funciona
    //Este get devuelve una lista con todos los productos y toda su información
    @GetMapping("/getProducts")
    public List<ProductEntity> getProducts() { return productService.getAllProducts(); }

    /* Este metodo actualiza cualquier dato de un producto,
    ya sean todos los datos a la vez o solo algunos
     */
    @PutMapping("/update/{code}")
    public ProductEntity updateProduct(@PathVariable Long code,
                                       @RequestParam(required = false, name = "productCode") Long newCode,
                                       @RequestParam(required = false, name = "name") String newName,
                                       @RequestParam(required = false, name = "brand") String newBrand,
                                       @RequestParam(required = false, name = "cost") Double newCost,
                                       @RequestParam(required = false, name = "stock") Double newStock) {
        return productService.editProduct(code, newCode, newName, newBrand, newCost, newStock);
    }

    //Esta solicitud elimina de la BD un producto, pasandole el codigo del producto por la URL
    @DeleteMapping("/delete/{productCode}")
    public String deleteProductForId(@PathVariable Long productCode) { return  productService.deleteProduct(productCode); }


}
