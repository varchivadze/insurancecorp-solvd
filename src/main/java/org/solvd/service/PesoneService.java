package org.solvd.service;

import org.solvd.staff.Person;
import org.solvd.support.Address;

import java.util.List;

public interface PesoneService {

    Person create(Person person);

    Person retrieveById(Long id);

    List<Person> retrieveAll();

    Person update(Person person);

    void deleteById(Long id);
}
