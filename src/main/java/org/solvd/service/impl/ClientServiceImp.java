package org.solvd.service.impl;

import org.solvd.domain.staff.Client;
import org.solvd.persistance.ClientRepository;
import org.solvd.persistance.impl.ClientRepositoryImp;
import org.solvd.service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImp() {
        this.clientRepository = new ClientRepositoryImp();
    }

    @Override
    public Client create(Client client, Long companyId) {
        client.setId(null);
        try {
            clientRepository.create(client, companyId);
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not handle create for client %s", client), e);
        }

    }

    @Override
    public Client retrieveById(Long id) {
        try {
            return clientRepository.findById(id).orElse(null);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Database error while retrieving client with id %d", id), e);
        }
    }

    @Override
    public List<Client> retrieveAll() {
        try {
            return clientRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll for clients", e);
        }

    }

    @Override
    public Client update(Client client) {
        try {
            clientRepository.update(client);
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update client %s", client), e);
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete client by id %d", id), e);
        }

    }
}
