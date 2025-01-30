package org.solvd.service;

import org.solvd.domain.staff.Employee;

public interface EmployeeService extends CrudService<Employee> {

    Employee create(Employee t, Long companyId);
}
