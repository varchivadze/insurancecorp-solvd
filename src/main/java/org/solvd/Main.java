package org.solvd;

import org.solvd.domain.accident.Accident;
import org.solvd.domain.services.Insurance;
import org.solvd.domain.services.InsuranceCompany;
import org.solvd.domain.services.Listeners;
import org.solvd.domain.staff.*;
import org.solvd.domain.support.Address;
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
//
        Address address = new Address();
        address.setCountry("Country");
        address.setCity("city");
        address.setPostalCode("11-111");
        address.setStreet("street");
        address.setUnit("57");
        addressService.create(address);
        address.setUnit("57");
        addressService.update(address);
        System.out.println(addressService.retrieveAll());
        System.out.println(address.getId());


        Person person = new Person();
        person.setHomeAddress(address);
        person.setDob(LocalDate.parse("2000-01-01"));
        person.setName("new name");
        person.setSurname("New surname");
        person.setTelephoneNumber("111222333");
        person = personeService.create(person);
        System.out.println(personeService.retrieveById(person.getPersonId()));
        System.out.println(personeService.retrieveAll());
        person.setSurname("123 Surname");
        personeService.update(person);

        System.out.println(person.getPersonId());
        System.out.println("Retrieve person");
        System.out.println(personeService.retrieveById(person.getPersonId()));


        Client client = new Client();
        client.setDob(person.getDob());
        client.setPersonId(person.getPersonId());
        client.setName(person.getName());
        client.setSurname(person.getSurname());
        client.setTelephoneNumber(person.getTelephoneNumber());
        client.setHomeAddress(person.getHomeAddress());
        client.setDiscount(BigDecimal.ZERO);
        System.out.println(client);


        client.setPersonId(person.getPersonId());
        System.out.println(client.getPersonId());
        System.out.println(client);

        System.out.println("personId: " + client.getPersonId());
        clientService.create(client, 1L);

        client = clientService.retrieveById(client.getClientId());
        client.setDiscount(BigDecimal.TWO);
        clientService.update(client);
        System.out.println(clientService.retrieveAll());

        Employee employee = new Employee();

        Person personToHire = personeService.retrieveById(1L);
        employee.setPersonId(person.getPersonId());
        employee.setName(person.getName());
        employee.setSurname(person.getSurname());
        employee.setHomeAddress(person.getHomeAddress());
        employee.setBonus(BigDecimal.ZERO);
        employee.setSalary(BigDecimal.valueOf(5000));
        employee.setPosition("Cleaner");
        employee.setPassportId("sdsdgs23432");

        employeeService.create(employee, 1L);
        employeeService.retrieveById(employee.getEmployeeId());
        employee.setPassportId("141241243214412");
        System.out.println(employeeService.retrieveAll());


        personeService.deleteById(person.getPersonId());
        addressService.deleteById(address.getId());
        employeeService.retrieveById(employee.getEmployeeId());

        InsuranceCompany company = new InsuranceCompany();
        company.setName("ERGO");
        company.setAddress(addressService.retrieveById(5L));
        System.out.println(company.getAddress());
        insuranceCompanyService.create(company);

        System.out.println(insuranceCompanyService.retrieveById(company.getId()));
        company.setName("Balcia");
        insuranceCompanyService.update(company);
        System.out.println(insuranceCompanyService.retrieveAll());
        insuranceCompanyService.deleteById(company.getId());

        CallablePerson employeeFactory = Factory.createPerson("employee");
        CallablePerson clientFactory = Factory.createPerson("client");
        CallablePerson personFactory = Factory.createPerson("unknown");

        CallablePerson newPersone = FactoryProvider.getFactory("regular").create(Type.PERSON);



        employee.call();

        Insurance insurance = Insurance.builder()
                .policeNumber("1232fsfs")
                .insuredFrom(LocalDate.parse("2025-01-01"))
                .insuredTill(LocalDate.parse("2026-01-01"))
                .insuranceCoverage(new BigDecimal("5000000"))
                .oc(true)
                .build();
        System.out.println(insurance);

        InsuranceCompany insComp = insuranceCompanyService.retrieveById(1L);

        insComp.getClients().forEach(Listeners::addListener);
        insComp.getEmployees().forEach(Listeners::addListener);
        Accident accident = new Accident();
        accident.setId(1L);
        accident.setPlaceOfAccident(address);
        insComp.addAccident(accident);

        insComp.getClients().forEach(System.out::println);

    }
}