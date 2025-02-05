package org.solvd.service.impl;

import org.solvd.domain.support.Address;
import org.solvd.persistance.AddressRepository;
import org.solvd.persistance.impl.AddressRepositoryImp;
import org.solvd.service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl() {
        this.addressRepository = new AddressRepositoryImp();
    }

    @Override
    public Address create(Address address) {
        address.setId(null);
        addressRepository.create(address);
    }

    @Override
    public Address retrieveById(Long id) {

        return addressRepository.findById(id).orElse(null);

    }

    @Override
    public List<Address> retrieveAll() {

        return addressRepository.findAll();


    }

    @Override
    public Address update(Address address) {
        Address currentAddress = retrieveById(address.getId());
        currentAddress.setCountry(address.getCountry());
        currentAddress.setCity(address.getCity());
        currentAddress.setPostalCode(address.getPostalCode());
        currentAddress.setStreet(address.getStreet());
        currentAddress.setUnit(address.getUnit());
        addressRepository.update(currentAddress);
        return currentAddress;

    }

    @Override
    public void deleteById(Long id) {

        addressRepository.deleteById(id);


    }
}
