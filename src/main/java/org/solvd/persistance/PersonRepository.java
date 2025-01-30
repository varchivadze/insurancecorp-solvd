package org.solvd.persistance;

import org.solvd.domain.staff.Person;

import java.sql.SQLException;

public interface PersonRepository extends CrudRepository<Person> {

    Person create(Person address) throws SQLException;
}
