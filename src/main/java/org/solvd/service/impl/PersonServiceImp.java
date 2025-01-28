package org.solvd.service.impl;

import org.solvd.persistance.PersonRepository;
import org.solvd.persistance.impl.PersonRepositoryImp;
import org.solvd.service.PersonService;
import org.solvd.staff.Person;

import java.sql.SQLException;
import java.util.List;

public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImp() {
        this.personRepository = new PersonRepositoryImp();
    }

    @Override
    public Person create(Person person) {
        person.setId(null);
        try {
            personRepository.create(person);
            return person;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not create new person %s", person), e);
        }
    }

    @Override
    public Person retrieveById(Long id) {
        try {
            return personRepository.findById(id).orElseThrow(() -> new SQLException("Could not handle find person by id " + id.toString()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> retrieveAll() {
        try {
            return personRepository.findAll();

        } catch (SQLException e) {
            throw new RuntimeException("Could not find persons from database");
        }
    }

    @Override
    public Person update(Person person) {
        try {
            Person currentPerson = retrieveById(person.getId());
            currentPerson.setName(person.getName());
            currentPerson.setSurname(person.getSurname());
            currentPerson.setDob(person.getDob());
            currentPerson.setTelephoneNumber(person.getTelephoneNumber());
            currentPerson.setHomeAddress(person.getHomeAddress());
            personRepository.update(currentPerson);
            return currentPerson;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update person %d", person.getId()));
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            personRepository.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete person by id %d", id));
        }
    }
}
