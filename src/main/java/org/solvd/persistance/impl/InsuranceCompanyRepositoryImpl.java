package org.solvd.persistance.impl;

import org.solvd.domain.services.InsuranceCompany;
import org.solvd.domain.support.Address;
import org.solvd.persistance.ConnectionPool;
import org.solvd.persistance.InsuranceCompanyRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InsuranceCompanyRepositoryImpl implements InsuranceCompanyRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public InsuranceCompany create(InsuranceCompany insuranceCompany) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "insert into insurance_companies (name, address_id) values (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, insuranceCompany.getName());
            preparedStatement.setLong(2, insuranceCompany.getAddress().getId());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                insuranceCompany.setId(resultSet.getLong(1));
            }
            return insuranceCompany;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create insurance company.", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<InsuranceCompany> findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select ic.id as insurance_company_id, ic.name, " +
                "a.id as address_id, a.country as address_country, a.city as address_city," +
                " a.postal_code as address_postal_code, a.street as address_street, a.unit as address_unit " +
                "FROM insurance_companies ic " +
                "LEFT JOIN addresses a ON ic.address_id = a.id " +
                "WHERE ic.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapRow(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not find insurance company with id %d.", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return Optional.empty();
    }

    @Override
    public List<InsuranceCompany> findAll() {
        List<InsuranceCompany> insuranceCompanies = new ArrayList<>();

        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "select ic.id as insurance_company_id, ic.name, " +
                "a.id as address_id, a.country as address_country, a.city as address_city," +
                " a.postal_code as address_postal_code, a.street as address_street, a.unit as address_unit " +
                "FROM insurance_companies ic " +
                "LEFT JOIN addresses a ON ic.address_id = a.id ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                insuranceCompanies.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll insurance company", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return insuranceCompanies;
    }

    @Override
    public void update(InsuranceCompany insuranceCompany) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "update insurance_companies SET name = ?, " +
                "address_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setString(1, insuranceCompany.getName());
            preparedStatement.setLong(2, insuranceCompany.getAddress().getId());
            preparedStatement.setLong(3, insuranceCompany.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update insurance company %d", insuranceCompany.getId()), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String statement = "delete from insurance_companies WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete insurance company with %d", id), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    protected InsuranceCompany mapRow(ResultSet resultSet) throws SQLException {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setId(resultSet.getLong("insurance_company_id"));
        insuranceCompany.setName(resultSet.getString("name"));

        Address address = AddressRepositoryImp.mapRow(resultSet);
        insuranceCompany.setAddress(address);

        return insuranceCompany;
    }

}
