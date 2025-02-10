package org.solvd.domain.staff;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.solvd.domain.support.Address;
import org.solvd.service.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlSeeAlso({Client.class, Employee.class})
public class Person {

    private Long id;
    private String name;
    private String surname;
    private LocalDate dob;
    private String telephoneNumber;
    @JsonProperty("Address")
    private Address homeAddress;

    public Person() {
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

    @XmlElement
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement()
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @XmlElement
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @XmlElement(name = "Address")
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return String.format("Person{id=%d, name='%s', surname='%s', dob=%s, telephoneNumber='%s', homeAddress=%s}",
                id, name, surname, dob, telephoneNumber, homeAddress);
    }
}
