package com.joni23s.finalWorkApiMarket.controllers;

import com.joni23s.finalWorkApiMarket.entities.ClientEntity;
import com.joni23s.finalWorkApiMarket.entities.ProductEntity;
import com.joni23s.finalWorkApiMarket.entities.SaleEntity;
import com.joni23s.finalWorkApiMarket.models.SaleModel;
import com.joni23s.finalWorkApiMarket.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/market/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/post")
    public SaleEntity postSale(@RequestBody SaleModel newSaleModel) {
        return saleService.createSale(newSaleModel);
    }

    //Funciona
    @GetMapping("/get/{saleCode}")
    public SaleEntity getSale(@PathVariable Long saleCode) { return saleService.getSale(saleCode); }

    //Funciona
    @GetMapping("/getSales")
    public List<SaleEntity> getSales() { return saleService.getAllSales(); }

    @PutMapping("/update/{code}")
    public SaleEntity updateSale(@PathVariable Long code,
                                       @RequestParam(required = false, name = "saleCode") Long newCode,
                                       @RequestParam(required = false, name = "saleDate") LocalDate newDate,
                                       @RequestParam(required = false, name = "total") Double newTotal,
                                       @RequestParam(required = false, name = "listProducts") List<ProductEntity> newProducts,
                                       @RequestParam(required = false, name = "aCustomer") ClientEntity newClient) {
        return saleService.editSale(code, newCode, newDate, newTotal, newProducts, newClient);
    }

    @DeleteMapping("/delete/{saleCode}")
    public String deleteSaleForId(@PathVariable Long saleCode) { return  saleService.deleteSale(saleCode); }
}
