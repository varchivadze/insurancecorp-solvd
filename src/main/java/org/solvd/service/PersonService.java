package org.solvd.service;

import org.solvd.staff.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    Person retrieveById(Long id);

    List<Person> retrieveAll();

    Person update(Person person);

    void deleteById(Long id);
}
