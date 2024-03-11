package com.joni23s.trabajoFinalApiBazar.controller;

import com.joni23s.trabajoFinalApiBazar.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
}
