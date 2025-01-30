package org.solvd.domain.accident;

import org.solvd.domain.services.Insurance;
import org.solvd.domain.staff.Person;

import java.time.Year;
import java.util.List;

public class Vehicle {

    private Long id;
    private Person owner;
    private String made;
    private String model;
    private Year yearProduced;
    private String plateNumber;
    private String vin;
    private Integer seats;
    private List<Insurance> insurances;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(Year yearProduced) {
        this.yearProduced = yearProduced;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }
}
