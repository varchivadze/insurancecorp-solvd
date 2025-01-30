package org.solvd.service;

import org.solvd.domain.support.Address;

public interface AddressService extends CrudService<Address> {

    Address create(Address t);
}
