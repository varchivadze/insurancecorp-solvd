package org.solvd.persistance;

import org.solvd.domain.staff.Employee;

import java.sql.SQLException;

public interface EmployeeRepository extends CrudRepository<Employee> {

    void create(Employee address, Long companyId);
}
