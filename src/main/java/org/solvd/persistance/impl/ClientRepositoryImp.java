package org.solvd.persistance.impl;

import org.solvd.domain.staff.Client;
import org.solvd.domain.support.Address;
import org.solvd.persistance.ClientRepository;
import org.solvd.persistance.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImp implements ClientRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private static final PersonRepositoryImp PERSON_REPOSITORY_IMP = new PersonRepositoryImp();

    public void create(Client client, Long companyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        if (client.getId() == null) {
            PERSON_REPOSITORY_IMP.create(client);
        } else {
            PERSON_REPOSITORY_IMP.update(client);
        }
        String statement = "insert into clients (person_id, discount, insurance_company_id) values (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, client.getId());
            preparedStatement.setBigDecimal(2, client.getDiscount());
            preparedStatement.setLong(3, companyId);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                client.setClientId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create client.", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Client> findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select " +
                "c.id AS client_id, c.discount, c.insurance_company_id, " +
                "p.id AS person_id, p.name, p.surname, p.dob, p.telephone_number, " +
                "a.id AS address_id, a.country, a.city, a.postal_code, a.street, a.unit " +
                "FROM clients c " +
                "JOIN persons p ON c.id = p.id " +
                "LEFT JOIN addresses a ON p.address_id = a.id " +
                "WHERE c.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapRow(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not find client with id %d.", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();

        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select " +
                "c.id AS client_id, c.discount, c.insurance_company_id, " +
                "p.id AS person_id, p.name, p.surname, p.dob, p.telephone_number, " +
                "a.id AS address_id, a.country, a.city, a.postal_code, a.street, a.unit " +
                "FROM clients c " +
                "JOIN persons p ON c.person_id = p.id " +
                "LEFT JOIN addresses a ON p.address_id = a.id ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clients.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll clients");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return clients;
    }

    @Override
    public void update(Client client) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update clients SET person_id = ?, discount = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, client.getId());
            preparedStatement.setBigDecimal(2, client.getDiscount());
            preparedStatement.setLong(3, client.getClientId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update client %d", client.getClientId()), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public void updateCompany(Client client, Long companyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update clients SET insurance_company_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, companyId);
            preparedStatement.setLong(2, client.getClientId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update client ID %d", companyId), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "delete from clients WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete client with %d", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    private Client mapRow(ResultSet resultSet) throws SQLException {

        Client client = new Client();
        client.setClientId(resultSet.getLong("client_id"));
        client.setDiscount(resultSet.getBigDecimal("discount"));

        client.setId(resultSet.getLong("person_id"));
        client.setName(resultSet.getString("name"));
        client.setSurname(resultSet.getString("surname"));
        client.setDob(resultSet.getDate("dob").toLocalDate());
        client.setTelephoneNumber(resultSet.getString("telephone_number"));

        Address address = new Address();
        address.setId(resultSet.getLong("address_id"));
        address.setCountry(resultSet.getString("country"));
        address.setCity(resultSet.getString("city"));
        address.setPostalCode(resultSet.getString("postal_code"));
        address.setStreet(resultSet.getString("street"));
        address.setUnit(resultSet.getString("unit"));
        client.setHomeAddress(address);

        return client;
    }
}
