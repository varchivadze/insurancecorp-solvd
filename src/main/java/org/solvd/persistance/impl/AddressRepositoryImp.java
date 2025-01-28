package org.solvd.persistance.impl;

import org.solvd.persistance.AddressRepository;
import org.solvd.persistance.ConnectionPool;
import org.solvd.support.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressRepositoryImp implements AddressRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Address address) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "insert into addresses(country, city, postal_code, street, unit) values (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getUnit());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                address.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create address.", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    @Override
    public Optional<Address> findById(Long id) {
        Optional<Address> result;

        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select a.id as address_id, a.country as address_country, a.city as address_city, " +
                "a.postal_code as address_postal_code, a.street as address_street, a.unit as address_unit " +
                "from addresses a WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            result = mapAddress(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Unable to find address with id %d.", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses;

        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select a.id as address_id, a.country as address_country, a.city as address_city," +
                "a.postal_code as address_postal_code, a.street as address_street, a.unit as address_unit " +
                "from addresses a";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            addresses = mapAddresses(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Could not find addresses", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return addresses;
    }

    @Override
    public void update(Address address) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update addresses set country = ?, city = ?, postal_code = ? , street = ?, unit = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPostalCode());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getUnit());
            preparedStatement.setLong(6, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Could not update address", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "delete from addresses where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException("Could not delete address", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }


    private static List<Address> mapAddresses(ResultSet resultSet) throws SQLException {
        List<Address> addresses = new ArrayList<>();
        while (resultSet.next()) {
            mapRow(resultSet, addresses);
        }
        return addresses;
    }

    private static Optional<Address> mapAddress(ResultSet resultSet) throws SQLException {
        return mapAddresses(resultSet).stream()
                .findFirst();
    }

    public static void mapRow(ResultSet resultSet, List<Address> addresses) throws SQLException {
        addresses.add(mapRow(resultSet));
    }

    public static Address mapRow(ResultSet resultSet) throws SQLException {
        Address address = null;

        long id = resultSet.getLong("address_id");
        if (id != 0) {
            address = new Address();
            address.setId(id);
            address.setCountry(resultSet.getString("address_country"));
            address.setCity(resultSet.getString("address_city"));
            address.setPostalCode(resultSet.getString("address_postal_code"));
            address.setStreet(resultSet.getString("address_street"));
            address.setUnit(resultSet.getString("address_unit"));
        }
        return address;
    }

}
