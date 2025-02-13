package org.solvd.persistance.impl;

import org.apache.ibatis.session.SqlSession;
import org.solvd.domain.support.Address;
import org.solvd.persistance.AddressRepository;
import org.solvd.persistance.MybatisSessionHolder;

import java.util.List;
import java.util.Optional;

public class AddressMapperImp implements AddressRepository {

    @Override
    public void create(Address address) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            addressRepository.create(address);
        }
    }

    @Override
    public Optional<Address> findById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            return addressRepository.findById(id);

        }
    }

    @Override
    public List<Address> findAll() {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            return addressRepository.findAll();

        }
    }

    @Override
    public void update(Address address) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            addressRepository.update(address);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            AddressRepository addressRepository = session.getMapper(AddressRepository.class);
            addressRepository.deleteById(id);
        }
    }
}
