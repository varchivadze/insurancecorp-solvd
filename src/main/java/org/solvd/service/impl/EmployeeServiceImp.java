package org.solvd.service.impl;

import org.solvd.domain.staff.Employee;
import org.solvd.persistance.EmployeeRepository;
import org.solvd.persistance.impl.EmployeeRepositoryImp;
import org.solvd.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp() {
        this.employeeRepository = new EmployeeRepositoryImp();
    }

    @Override
    public Employee create(Employee employee, Long companyId) {
        employee.setId(null);
        try {
            employeeRepository.create(employee, companyId);
            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not handle create for employee %s", employee), e);
        }

    }

    @Override
    public Employee retrieveById(Long id) {
        try {
            return employeeRepository.findById(id).orElse(null);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Database error while retrieving employee with id %d", id), e);
        }
    }

    @Override
    public List<Employee> retrieveAll() {
        try {
            return employeeRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll for employee", e);
        }

    }

    @Override
    public Employee update(Employee employee) {
        try {
            employeeRepository.update(employee);
            return employee;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update employee %s", employee), e);
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete employee by id %d", id), e);
        }

    }

}
