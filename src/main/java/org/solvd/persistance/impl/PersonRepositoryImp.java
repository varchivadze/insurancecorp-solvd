package org.solvd.persistance.impl;

import org.solvd.domain.staff.Person;
import org.solvd.domain.support.Address;
import org.solvd.persistance.ConnectionPool;
import org.solvd.persistance.PersonRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryImp implements PersonRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public void create(Person person) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "insert into persons (name, surname, dob, telephone_number, address_id) values (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setDate(3, Date.valueOf(person.getDob()));
            preparedStatement.setString(4, person.getTelephoneNumber());
            preparedStatement.setLong(5, person.getHomeAddress().getId());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                person.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create person.", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Person> findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select p.id AS person_id, p.name, p.surname, p.dob, p.telephone_number, " +
                "a.id AS address_id, a.country AS address_country, a.city AS address_city, " +
                "a.postal_code AS address_postal_code, a.street AS address_street, a.unit AS address_unit " +
                "FROM persons p " +
                "LEFT JOIN addresses a ON p.address_id = a.id " +
                "WHERE p.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapRow(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not find person with id %d.", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select p.id AS person_id, p.name, p.surname, p.dob, p.telephone_number, " +
                "a.id AS address_id, a.country AS address_country, a.city AS address_city, " +
                "a.postal_code AS address_postal_code, a.street AS address_street, a.unit AS address_unit " +
                "FROM persons p " +
                "LEFT JOIN addresses a ON p.address_id = a.id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                persons.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll persons");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return persons;
    }

    @Override
    public void update(Person person) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update persons SET name = ?, surname = ?, dob = ?, telephone_number = ?, " +
                "address_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setDate(3, Date.valueOf(person.getDob()));
            preparedStatement.setString(4, person.getTelephoneNumber());
            preparedStatement.setLong(5, person.getHomeAddress().getId());
            preparedStatement.setLong(6, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update person %d", person.getId()), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "delete from persons WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete person with %d", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    protected Person mapRow(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong("person_id"));
        person.setName(resultSet.getString("name"));
        person.setSurname(resultSet.getString("surname"));
        person.setDob(resultSet.getDate("dob").toLocalDate());
        person.setTelephoneNumber(resultSet.getString("telephone_number"));

        Address address = AddressRepositoryImp.mapRow(resultSet);
        person.setHomeAddress(address);

        return person;
    }
}
