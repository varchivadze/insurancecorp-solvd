package org.solvd.domain.staff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.solvd.domain.support.Address;
import org.solvd.service.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlSeeAlso({Client.class, Employee.class})
public class Person implements CallablePerson {

    private Long personId;
    private String name;
    private String surname;
    private LocalDate dob;
    private String telephoneNumber;
    @JsonProperty("Address")
    private Address homeAddress;

    public Person() {
    }

    @XmlElement
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
    public void call() {
        System.out.println("Calling person" + getName() + " " + getSurname());
    }

    @Override
    public String toString() {
        return String.format("Person{id=%d, name='%s', surname='%s', dob=%s, telephoneNumber='%s', homeAddress=%s}",
                personId, name, surname, dob, telephoneNumber, homeAddress);
    }
}
