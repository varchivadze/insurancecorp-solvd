package org.solvd.service;

import org.solvd.domain.staff.Person;

public interface PersonService extends CrudService<Person> {

    Person create(Person t);
}
