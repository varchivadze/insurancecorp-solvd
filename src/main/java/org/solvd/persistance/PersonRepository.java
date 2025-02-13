package org.solvd.persistance;

import org.solvd.domain.staff.Person;

import java.sql.SQLException;

public interface PersonRepository extends CrudRepository<Person> {

    void create(Person address);
}
