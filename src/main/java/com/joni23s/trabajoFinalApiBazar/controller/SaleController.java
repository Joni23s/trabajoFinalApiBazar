package com.joni23s.trabajoFinalApiBazar.controller;

import com.joni23s.trabajoFinalApiBazar.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;
}
