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

        clientRepository.create(client, companyId);
        return client;


    }

    @Override
    public Client retrieveById(Long id) {

        return clientRepository.findById(id).orElse(null);

    }

    @Override
    public List<Client> retrieveAll() {

        return clientRepository.findAll();


    }

    @Override
    public Client update(Client client) {

        clientRepository.update(client);
        return client;


    }

    @Override
    public void deleteById(Long id) {

        clientRepository.deleteById(id);


    }
}
