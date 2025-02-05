package org.solvd.persistance;

import org.solvd.domain.staff.Client;

import java.sql.SQLException;

public interface ClientRepository extends CrudRepository<Client> {

    void create(Client address, Long companyId);
}
