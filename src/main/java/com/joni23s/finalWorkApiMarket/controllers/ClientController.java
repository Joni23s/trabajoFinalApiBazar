package com.joni23s.finalWorkApiMarket.controllers;

import com.joni23s.finalWorkApiMarket.entities.ClientEntity;
import com.joni23s.finalWorkApiMarket.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //Funciona
    @PostMapping("/post")
    public ClientEntity postClient(@RequestBody ClientEntity newClient) { return clientService.createClient(newClient); }

    //Funciona
    @GetMapping("/get/{idClient}")
    public ClientEntity getClient(@PathVariable Long idClient) { return clientService.getClient(idClient); }

    //Funciona
    @GetMapping("/getClients")
    public List<ClientEntity> getClients() { return clientService.getAllClients(); }

    //Funciona
    @PutMapping("/update/{id}")
    public ClientEntity updateClient(@PathVariable Long id,
                                     @RequestParam(required = false, name = "idClient") Long newId,
                                     @RequestParam(required = false, name = "name") String newName,
                                     @RequestParam(required = false, name = "lastName") String newLastName,
                                     @RequestParam(required = false, name = "dni") int newDni) {

        return clientService.editClient(id, newId, newName, newLastName, newDni);
    }

    //Funciona
    @DeleteMapping("/delete/{idClient}")
    public String deleteClientForId(@PathVariable Long idClient) { return clientService.deleteClient(idClient);}


}
