package org.solvd.services;

import org.solvd.accident.Vehicle;
import org.solvd.staff.Client;
import org.solvd.staff.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Insurance {

    private String policeNumber;
    private Client insured;
    private Vehicle insuredVehicle;
    private InsuranceCompany insurer;
    private LocalDate insuredFrom;
    private LocalDate insuredTill;
    private BigDecimal insuranceCoverage;
    private boolean isOc;

    public String getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
    }

    public Client getInsured() {
        return insured;
    }

    public void setInsured(Client insured) {
        this.insured = insured;
    }

    public Vehicle getInsuredVehicle() {
        return insuredVehicle;
    }

    public void setInsuredVehicle(Vehicle insuredVehicle) {
        this.insuredVehicle = insuredVehicle;
    }

    public InsuranceCompany getInsurer() {
        return insurer;
    }

    public void setInsurer(InsuranceCompany insurer) {
        this.insurer = insurer;
    }

    public LocalDate getInsuredFrom() {
        return insuredFrom;
    }

    public void setInsuredFrom(LocalDate insuredFrom) {
        this.insuredFrom = insuredFrom;
    }

    public LocalDate getInsuredTill() {
        return insuredTill;
    }

    public void setInsuredTill(LocalDate insuredTill) {
        this.insuredTill = insuredTill;
    }

    public BigDecimal getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(BigDecimal insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    public boolean isOc() {
        return isOc;
    }

    public void setOc(boolean oc) {
        isOc = oc;
    }
}
