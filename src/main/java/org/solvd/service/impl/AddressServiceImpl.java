package org.solvd.service.impl;

import org.solvd.persistance.AddressRepository;
import org.solvd.persistance.CrudRepository;
import org.solvd.persistance.impl.AddressRepositoryImp;
import org.solvd.service.AddressService;
import org.solvd.support.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public  AddressServiceImpl() {
        this.addressRepository = new AddressRepositoryImp();
    }

    @Override
    public Address create(Address address) {
        address.setId(null);
        try {
            addressRepository.create(address);
            return address;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not handle create for address %s", address), e);
        }

    }

    @Override
    public Address retrieveById(Long id) {
        try {
            return addressRepository.findById(id).orElse(null);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Database error while retrieving address with id %d", id), e);
        }
    }

    @Override
    public List<Address> retrieveAll() {
        try {
            return addressRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll for Addresses", e);
        }

    }

    @Override
    public Address update(Address address) {
        try {
            Address currentAddress = retrieveById(address.getId());
            currentAddress.setCountry(address.getCountry());
            currentAddress.setCity(address.getCity());
            currentAddress.setPostalCode(address.getPostalCode());
            currentAddress.setStreet(address.getStreet());
            currentAddress.setUnit(address.getUnit());
            addressRepository.update(currentAddress);
            return currentAddress;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update Address %s", address), e);
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
            addressRepository.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete Address by id %d", id), e);
        }

    }
}
