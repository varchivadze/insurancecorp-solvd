package org.solvd.accident;

import org.solvd.staff.Employee;
import org.solvd.support.Address;

import java.time.ZonedDateTime;
import java.util.List;

public class Accident {

    private Long id;
    private ZonedDateTime date;
    private Address placeOfAccident;
    private List<Vehicle> damagedVehicles;
    private Vehicle culpritVehicle;
    private Employee appraiser;
    private Employee assistant;
    private List<RepairOrder> repairs;
    private String notes;

    public Accident() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Address getPlaceOfAccident() {
        return placeOfAccident;
    }

    public void setPlaceOfAccident(Address placeOfAccident) {
        this.placeOfAccident = placeOfAccident;
    }

    public List<Vehicle> getDamagedVehicles() {
        return damagedVehicles;
    }

    public void setDamagedVehicles(List<Vehicle> damagedVehicles) {
        this.damagedVehicles = damagedVehicles;
    }

    public Vehicle getCulpritVehicle() {
        return culpritVehicle;
    }

    public void setCulpritVehicle(Vehicle culpritVehicle) {
        this.culpritVehicle = culpritVehicle;
    }

    public Employee getAppraiser() {
        return appraiser;
    }

    public void setAppraiser(Employee appraiser) {
        this.appraiser = appraiser;
    }

    public Employee getAssistant() {
        return assistant;
    }

    public void setAssistant(Employee assistant) {
        this.assistant = assistant;
    }

    public List<RepairOrder> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<RepairOrder> repairs) {
        this.repairs = repairs;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
