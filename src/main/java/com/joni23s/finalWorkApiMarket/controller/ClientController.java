package com.joni23s.finalWorkApiMarket.controller;

import com.joni23s.finalWorkApiMarket.entity.ClientEntity;
import com.joni23s.finalWorkApiMarket.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/post")
    public ClientEntity postClient(@RequestBody ClientEntity newClient) { return clientService.createClient(newClient); }

    @GetMapping("/get/{idClient}")
    public ClientEntity getClient(@PathVariable Long idClient) { return clientService.getClient(idClient); }

    @GetMapping("/getClients")
    public List<ClientEntity> getClients() { return clientService.getAllClients(); }

    @PutMapping("/update/{id}")
    public ClientEntity updateClient(@PathVariable Long id,
                                     @RequestParam(required = false, name = "idClient") Long newId,
                                     @RequestParam(required = false, name = "name") String newName,
                                     @RequestParam(required = false, name = "lastName") String newLastName,
                                     @RequestParam(required = false, name = "dni") int newDni) {

        return clientService.editClient(id, newId, newName, newLastName, newDni);
    }

    @DeleteMapping("/delete/{idClient}")
    public String deleteClientForId(@PathVariable Long idClient) { return clientService.deleteClient(idClient);}


}
