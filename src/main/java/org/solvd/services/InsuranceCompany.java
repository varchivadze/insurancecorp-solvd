package org.solvd.services;

import org.solvd.accident.Accident;
import org.solvd.staff.Client;
import org.solvd.staff.Employee;
import org.solvd.support.Address;

import java.util.List;

public class InsuranceCompany {

    private Long id;
    private String name;
    private Address address;
    private List<Employee> employees;
    private List<Client> clients;

    public InsuranceCompany() {
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
