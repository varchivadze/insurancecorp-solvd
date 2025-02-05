package org.solvd;

import org.solvd.domain.staff.Client;
import org.solvd.service.*;
import org.solvd.service.impl.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AddressService addressService = new AddressServiceImpl();
        PersonService personeService = new PersonServiceImp();
        EmployeeService employeeService = new EmployeeServiceImp();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyServiceImp();
        ClientService clientService = new ClientServiceImp();
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
//        Person gotPerson = personeService.retrieveById(19L);
//        System.out.println(gotPerson);
//        Employee newEmployee = new Employee();
//        newEmployee.setId(gotPerson.getId());
//        newEmployee.setName(gotPerson.getName());
//        newEmployee.setSurname(gotPerson.getSurname());
//        newEmployee.setDob(gotPerson.getDob());
//        newEmployee.setTelephoneNumber(gotPerson.getTelephoneNumber());
//        newEmployee.setHomeAddress(gotPerson.getHomeAddress());
//        newEmployee.setPosition("Manager");
//        newEmployee.setSalary(new BigDecimal("5000"));
//        newEmployee.setBonus(new BigDecimal("500"));
//        newEmployee.setPassportId("GG500600");

//        employeeService.create(newEmployee, 1L);
//        Employee retrievedEmployee = employeeService.retrieveById(5L);
////        System.out.println("\n \n");
////        System.out.println(employeeService.retrieveAll());
//        retrievedEmployee.setBonus(BigDecimal.ZERO);
//        employeeService.update(retrievedEmployee);
//        System.out.println("\n \n");
//        System.out.println(employeeService.retrieveById(retrievedEmployee.getEmployeeId()));
//
//        personeService.deleteById(19L);
//        personeService.deleteById(20L);
//        personeService.deleteById(21L);
//        personeService.deleteById(22L);

//        System.out.println(insuranceCompanyService.retrieveAll());
//        System.out.println(insuranceCompanyService.retrieveById(1L));
//        InsuranceCompany newInsuranceCompany = new InsuranceCompany();
//        newInsuranceCompany.setName("newCompany");
//        Address newAddress = addressService.retrieveById(5L);
//        newInsuranceCompany.setAddress(newAddress);
//        insuranceCompanyService.create(newInsuranceCompany);
//        System.out.println(insuranceCompanyService.retrieveById(2L));

//        insuranceCompanyService.deleteById(2L);
//        System.out.println(insuranceCompanyService.retrieveAll());
//        InsuranceCompany temp = insuranceCompanyService.retrieveById(1L);
//        temp.setName(temp.getName() + "temp");
//        insuranceCompanyService.update(temp);
//        System.out.println(insuranceCompanyService.retrieveById(1L));
//        Client tempClient = clientService.retrieveById(1L);
//        System.out.println(tempClient);
//        tempClient.setDiscount(new BigDecimal("1000"));
//        clientService.update(tempClient);
//
//        Client newClient = new Client();
//        newClient.setName("Client");
//        newClient.setSurname("Client_new");
//        newClient.setDob(LocalDate.parse("2000-02-01"));
//        newClient.setTelephoneNumber("123");
//        newClient.setHomeAddress(addressService.retrieveById(5L));
//        newClient.setDiscount(BigDecimal.ONE);
//        clientService.create(newClient, 1L);
//        System.out.println(clientService.retrieveById(newClient.getClientId()));
//        System.out.println(clientService.retrieveAll());

    }
}