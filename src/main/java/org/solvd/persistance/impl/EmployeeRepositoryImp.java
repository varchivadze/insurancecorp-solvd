package org.solvd.persistance.impl;

import org.solvd.domain.staff.Employee;
import org.solvd.domain.support.Address;
import org.solvd.persistance.ConnectionPool;
import org.solvd.persistance.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImp implements EmployeeRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private static final PersonRepositoryImp PERSON_REPOSITORY_IMP = new PersonRepositoryImp();

    public void create(Employee employee, Long companyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        if (employee.getPersonId() == null) {
            PERSON_REPOSITORY_IMP.create(employee);
        } else {
            PERSON_REPOSITORY_IMP.update(employee);
        }
        String statement = "insert into employees (position, salary, bonus, passport_id, person_id, insurance_company_id) values (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employee.getPosition());
            preparedStatement.setBigDecimal(2, employee.getSalary());
            preparedStatement.setBigDecimal(3, employee.getBonus());
            preparedStatement.setString(4, employee.getPassportId());
            preparedStatement.setLong(5, employee.getPersonId());
            preparedStatement.setLong(6, companyId);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create employee.", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select " +
                "e.id AS employee_id, e.position, e.salary, e.bonus, e.passport_id, " +
                "p.id AS person_id, p.name, p.surname, p.dob, p.telephone_number, " +
                "a.id AS address_id, a.country, a.city, a.postal_code, a.street, a.unit " +
                "FROM employees e " +
                "JOIN persons p ON e.person_id = p.id " +
                "LEFT JOIN addresses a ON p.address_id = a.id " +
                "WHERE e.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapRow(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not find employee with id %d.", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();

        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select " +
                "e.id AS employee_id, e.position, e.salary, e.bonus, e.passport_id, " +
                "p.id AS person_id, p.name, p.surname, p.dob, p.telephone_number, " +
                "a.id AS address_id, a.country, a.city, a.postal_code, a.street, a.unit " +
                "FROM employees e " +
                "JOIN persons p ON e.person_id = p.id " +
                "LEFT JOIN addresses a ON p.address_id = a.id ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll employees");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return employees;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update employees SET position = ?, salary = ?, bonus = ?, passport_id =?, " +
                "person_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setString(1, employee.getPosition());
            preparedStatement.setBigDecimal(2, employee.getSalary());
            preparedStatement.setBigDecimal(3, employee.getBonus());
            preparedStatement.setString(4, employee.getPassportId());
            preparedStatement.setLong(5, employee.getPersonId());
            preparedStatement.setLong(6, employee.getEmployeeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update employee %d", employee.getEmployeeId()), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public void updateCompany(Employee employee, Long companyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update employees SET insurance_company_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, companyId);
            preparedStatement.setLong(2, employee.getEmployeeId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update company ID %d for employee", companyId), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "delete from employees WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete employee with %d", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    private Employee mapRow(ResultSet resultSet) throws SQLException {

        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getLong("employee_id"));
        employee.setPosition(resultSet.getString("position"));
        employee.setSalary(resultSet.getBigDecimal("salary"));
        employee.setBonus(resultSet.getBigDecimal("bonus"));
        employee.setPassportId(resultSet.getString("passport_id"));

        employee.setPersonId(resultSet.getLong("person_id"));
        employee.setName(resultSet.getString("name"));
        employee.setSurname(resultSet.getString("surname"));
        employee.setDob(resultSet.getDate("dob").toLocalDate());
        employee.setTelephoneNumber(resultSet.getString("telephone_number"));

        Address address = new Address();
        address.setId(resultSet.getLong("address_id"));
        address.setCountry(resultSet.getString("country"));
        address.setCity(resultSet.getString("city"));
        address.setPostalCode(resultSet.getString("postal_code"));
        address.setStreet(resultSet.getString("street"));
        address.setUnit(resultSet.getString("unit"));
        employee.setHomeAddress(address);

        return employee;
    }

}
