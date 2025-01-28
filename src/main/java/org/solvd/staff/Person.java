package org.solvd.staff;

import org.solvd.support.Address;

import java.time.LocalDate;

public class Person {

    private Long id;
    private String name;
    private String surname;
    private LocalDate dob;
    private String telephoneNumber;
    private Address homeAddress;

    public Person() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return String.format("%nPerson %s %s %s %s %s %nHome Address: %s",
                id, name, surname, dob, telephoneNumber, homeAddress);
    }
}
