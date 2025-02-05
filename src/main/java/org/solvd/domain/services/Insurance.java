package org.solvd.domain.services;

import org.solvd.domain.accident.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Insurance {

    private Long id;
    private String policeNumber;
    private LocalDate insuredFrom;
    private LocalDate insuredTill;
    private BigDecimal insuranceCoverage;
    private Boolean oc;

    public Insurance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
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

    public Boolean getOc() {
        return oc;
    }

    public void setOc(Boolean oc) {
        this.oc = oc;
    }
}
