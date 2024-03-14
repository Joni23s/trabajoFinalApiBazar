package com.joni23s.finalWorkApiMarket.service;

import com.joni23s.finalWorkApiMarket.entity.ClientEntity;
import com.joni23s.finalWorkApiMarket.entity.ProductEntity;
import com.joni23s.finalWorkApiMarket.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity createClient(ClientEntity newClient) { return clientRepository.save(newClient); }

    public ClientEntity getClient(Long id) {return clientRepository.findById(id).orElse(null); }

    public List<ClientEntity> getAllClients() {return clientRepository.findAll(); }

    public ClientEntity editClient(Long id, Long newId, String newName, String newLastName, int newDni) {
        ClientEntity client = clientRepository.findById(id).orElse(null);

        client.setIdClient(newId);
        client.setName(newName);
        client.setLastName(newLastName);
        client.setDni(newDni);

        clientRepository.save(client);
        return client;

    }

    public String deleteClient(Long id) {
        try {
            ClientEntity clientOld = clientRepository.findById(id).orElse(null);

            clientRepository.deleteById(id);

            return "Cliente: " + clientOld.getName() + clientOld.getLastName() + ". Eliminado";

        } catch (EntityNotFoundException e) {

            throw new RuntimeException("Error al buscar el cliente", e);
        }
    }

}
