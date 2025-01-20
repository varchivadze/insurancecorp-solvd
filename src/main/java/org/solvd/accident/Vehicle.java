package org.solvd.accident;

import org.solvd.services.Insurance;
import org.solvd.staff.Person;

import java.time.Year;
import java.util.List;

public class Vehicle {

    private long id;
    private Person owner;
    private String made;
    private String model;
    private Year yearProduced;
    private String plateNumber;
    private String vin;
    private int seats;
    private List<Insurance> insurances;

    public Vehicle(long id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void addInsurance(Insurance insurance) {
        this.insurances.add(insurance);
    }

    public void removeInsurance(Insurance insurance) {
        this.insurances.remove(insurance);
    }

    public long getId() {
        return id;
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
