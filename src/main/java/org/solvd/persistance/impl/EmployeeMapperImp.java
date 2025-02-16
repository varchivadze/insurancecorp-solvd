package org.solvd.persistance.impl;

import org.apache.ibatis.session.SqlSession;
import org.solvd.domain.staff.Employee;
import org.solvd.persistance.EmployeeRepository;
import org.solvd.persistance.MybatisSessionHolder;

import java.util.List;
import java.util.Optional;

public class EmployeeMapperImp implements EmployeeRepository {

    @Override
    public void create(Employee employee, Long insCompId) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.create(employee, insCompId);
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            return employeeRepository.findById(id);

        }
    }

    @Override
    public List<Employee> findAll() {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            return employeeRepository.findAll();

        }
    }

    @Override
    public void update(Employee employee) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.update(employee);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.deleteById(id);
        }
    }
}
