package org.solvd.accident;

import org.solvd.services.Workshop;
import org.solvd.staff.Employee;
import org.solvd.support.Address;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RepairOrder {

    private long id;
    private LocalDate date;
    private Workshop workShop;
    private Employee manager;
    private BigDecimal cost;
    private String description;
    private BigDecimal paid;
    private boolean complete;

    public RepairOrder(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Workshop getWorkShop() {
        return workShop;
    }

    public void setWorkShop(Workshop workShop) {
        this.workShop = workShop;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
