package org.solvd.persistance;

import org.solvd.domain.support.Address;

import java.sql.SQLException;

public interface AddressRepository extends CrudRepository<Address> {

    void create(Address address) throws SQLException;
}
