package org.solvd.services;

import org.solvd.accident.Accident;
import org.solvd.staff.Employee;
import org.solvd.support.Address;

import java.util.List;

public class InsuranceCompany {

    private long id;
    private String name;
    private Address address;
    private List<Employee> employees;
    private List<Accident> accidents;

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

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }
}
