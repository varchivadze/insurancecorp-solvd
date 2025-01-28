package org.solvd;
import org.solvd.service.AddressService;
import org.solvd.service.PesoneService;
import org.solvd.service.impl.AddressServiceImpl;
import org.solvd.service.impl.PersonServiceImp;
import org.solvd.staff.Person;
import org.solvd.support.Address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AddressService addressService = new AddressServiceImpl();
        PesoneService personeService = new PersonServiceImp();
//
        personeService.deleteById(11L);
        personeService.deleteById(12L);
        personeService.deleteById(13L);
        personeService.deleteById(14L);
        personeService.deleteById(15L);
        personeService.deleteById(16L);
        personeService.deleteById(17L);
        personeService.deleteById(18L);
//        Address gotAddress = addressService.retrieveById(1L);
//        System.out.println(gotAddress);
//        gotAddress.setUnit("11111");
//        Address pdatedAddress = addressService.update(gotAddress);
//        System.out.println(pdatedAddress);
//        gotAddress.setStreet("New street");
//        Address newAdress = addressService.create(gotAddress);
//        System.out.println(newAdress);
//
//        System.out.println(addressService.retrieveAll());

//        System.out.println(personeService.retrieveAll());
//        Person newPersone = new Person();
//        newPersone.setName("Andrei");
//        newPersone.setSurname("Andreivich");
//        newPersone.setDob(LocalDate.parse("2000-01-01"));
//        newPersone.setTelephoneNumber("+2342342342423");
//        newPersone.setHomeAddress(newAdress);
//        personeService.create(newPersone);
//        System.out.println(personeService.retrieveAll());
//        personeService.deleteById(9L);
//        personeService.deleteById(10L);
//        newPersone.setHomeAddress(addressService.retrieveById(2L));
//        personeService.update(newPersone);
    }
}