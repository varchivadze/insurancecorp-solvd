package org.solvd.service.impl;

import org.solvd.domain.staff.Person;
import org.solvd.persistance.PersonRepository;
import org.solvd.persistance.impl.PersonMapperImp;
import org.solvd.persistance.impl.PersonRepositoryImp;
import org.solvd.service.PersonService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImp() {
//        this.personRepository = new PersonRepositoryImp();
        this.personRepository = new PersonMapperImp();
    }

    @Override
    public Person create(Person person) {
        person.setId(null);

        personRepository.create(person);
        return person;

    }

    @Override
    public Person retrieveById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Could not handle find person by id " + id));
    }

    @Override
    public List<Person> retrieveAll() {
        return personRepository.findAll();
    }

    @Override
    public Person update(Person person) {
        Person currentPerson = retrieveById(person.getId());
        currentPerson.setName(person.getName());
        currentPerson.setSurname(person.getSurname());
        currentPerson.setDob(person.getDob());
        currentPerson.setTelephoneNumber(person.getTelephoneNumber());
        currentPerson.setHomeAddress(person.getHomeAddress());
        personRepository.update(currentPerson);
        return currentPerson;

    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
