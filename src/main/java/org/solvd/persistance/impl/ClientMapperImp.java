package org.solvd.persistance.impl;

import org.apache.ibatis.session.SqlSession;
import org.solvd.domain.staff.Client;
import org.solvd.persistance.ClientRepository;
import org.solvd.persistance.MybatisSessionHolder;

import java.util.List;
import java.util.Optional;

public class ClientMapperImp implements ClientRepository {

    @Override
    public void create(Client client, Long insCompId) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            ClientRepository clientRepository = session.getMapper(ClientRepository.class);
            clientRepository.create(client, insCompId);
        }
    }

    @Override
    public Optional<Client> findById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            ClientRepository clientRepository = session.getMapper(ClientRepository.class);
            return clientRepository.findById(id);

        }
    }

    @Override
    public List<Client> findAll() {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            ClientRepository clientRepository = session.getMapper(ClientRepository.class);
            return clientRepository.findAll();

        }
    }

    @Override
    public void update(Client client) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            ClientRepository clientRepository = session.getMapper(ClientRepository.class);
            clientRepository.update(client);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            ClientRepository clientRepository = session.getMapper(ClientRepository.class);
            clientRepository.deleteById(id);
        }
    }
}


