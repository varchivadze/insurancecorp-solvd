package org.solvd.service.impl;

import org.solvd.domain.staff.Employee;
import org.solvd.persistance.EmployeeRepository;
import org.solvd.persistance.impl.EmployeeMapperImp;
import org.solvd.persistance.impl.EmployeeRepositoryImp;
import org.solvd.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp() {
        this.employeeRepository = new EmployeeMapperImp();
//        this.employeeRepository = new EmployeeRepositoryImp();
    }

    @Override
    public Employee create(Employee employee, Long companyId) {
        employee.setEmployeeId(null);

        employeeRepository.create(employee, companyId);
        return employee;


    }

    @Override
    public Employee retrieveById(Long id) {

        return employeeRepository.findById(id).orElse(null);

    }

    @Override
    public List<Employee> retrieveAll() {

        return employeeRepository.findAll();

    }

    @Override
    public Employee update(Employee employee) {

        employeeRepository.update(employee);
        return employee;


    }

    @Override
    public void deleteById(Long id) {

        employeeRepository.deleteById(id);


    }

}
