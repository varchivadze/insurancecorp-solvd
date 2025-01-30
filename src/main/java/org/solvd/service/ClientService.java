package org.solvd.service;

import org.solvd.domain.staff.Client;

public interface ClientService extends CrudService<Client> {

    Client create(Client t, Long companyId);
}
