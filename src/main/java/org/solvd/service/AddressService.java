package org.solvd.service;

import org.solvd.support.Address;

import java.util.List;

public interface AddressService {

    Address create(Address address);

    Address retrieveById(Long id);

    List<Address> retrieveAll();

    Address update(Address address);

    void deleteById(Long id);
}
