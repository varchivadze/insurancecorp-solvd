package org.solvd.accident;

import org.solvd.services.Workshop;
import org.solvd.staff.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RepairOrder {

    private Long id;
    private LocalDate date;
    private Workshop workShop;
    private BigDecimal cost;
    private String description;
    private BigDecimal paid;
    private Boolean complete;

    public RepairOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Workshop getWorkShop() {
        return workShop;
    }

    public void setWorkShop(Workshop workShop) {
        this.workShop = workShop;
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

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
