package org.solvd.persistance.impl;

import org.apache.ibatis.session.SqlSession;
import org.solvd.domain.staff.Person;
import org.solvd.persistance.MybatisSessionHolder;
import org.solvd.persistance.PersonRepository;

import java.util.List;
import java.util.Optional;

public class PersonMapperImp implements PersonRepository {
    @Override
    public void create(Person person) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PersonRepository personRepository = session.getMapper(PersonRepository.class);
            personRepository.create(person);
        }
    }

    @Override
    public Optional<Person> findById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PersonRepository personRepository = session.getMapper(PersonRepository.class);
            return personRepository.findById(id);
        }
    }

    @Override
    public List<Person> findAll() {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PersonRepository personRepository = session.getMapper(PersonRepository.class);
            return personRepository.findAll();
        }
    }

    @Override
    public void update(Person person) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PersonRepository personRepository = session.getMapper(PersonRepository.class);
            personRepository.update(person);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            PersonRepository personRepository = session.getMapper(PersonRepository.class);
            personRepository.deleteById(id);
        }
    }
}
