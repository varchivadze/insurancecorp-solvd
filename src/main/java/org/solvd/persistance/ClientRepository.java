package org.solvd.persistance;

import org.apache.ibatis.annotations.Param;
import org.solvd.domain.staff.Client;

public interface ClientRepository extends CrudRepository<Client> {

    void create(@Param("client") Client client, @Param("companyId") Long companyId);
}
