package org.solvd.domain.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.solvd.domain.staff.Client;
import org.solvd.domain.staff.Employee;
import org.solvd.domain.support.Address;

import javax.xml.bind.annotation.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "InsuranceCompany")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class InsuranceCompany {

    private Long id;
    private String name;
    @JsonProperty("Address")
    private Address address;
    private List<Employee> employees;
    private List<Client> clients;

    public InsuranceCompany() {
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "Employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "Client")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return String.format("InsuranceCompany{id=%d, name='%s', address=%s, employees=%s, clients=%s}",
                id, name, address, employees, clients);
    }
}
