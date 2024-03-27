package com.joni23s.finalWorkApiMarket.services;

import com.joni23s.finalWorkApiMarket.entities.ClientEntity;
import com.joni23s.finalWorkApiMarket.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

            return "Cliente: " + clientOld.getName() + " " + clientOld.getLastName() + ". Eliminado";

        } catch (EntityNotFoundException e) {

            throw new RuntimeException("Error al buscar el cliente ", e);
        }
    }

}
