package com.joni23s.finalWorkApiMarket.controller;

import com.joni23s.finalWorkApiMarket.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;
}
