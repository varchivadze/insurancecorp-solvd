package org.solvd.domain.services;

import org.solvd.domain.staff.Employee;
import org.solvd.service.LocalDateAdapter;

import javax.swing.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Insurance {

    private Long id;
    private String policeNumber;
    private LocalDate insuredFrom;
    private LocalDate insuredTill;
    private BigDecimal insuranceCoverage;
    private Boolean oc;

    public Insurance() {
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getPoliceNumber() {
        return policeNumber;
    }

    public void setPoliceNumber(String policeNumber) {
        this.policeNumber = policeNumber;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement()
    public LocalDate getInsuredFrom() {
        return insuredFrom;
    }

    public void setInsuredFrom(LocalDate insuredFrom) {
        this.insuredFrom = insuredFrom;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement()
    public LocalDate getInsuredTill() {
        return insuredTill;
    }

    public void setInsuredTill(LocalDate insuredTill) {
        this.insuredTill = insuredTill;
    }

    @XmlElement
    public BigDecimal getInsuranceCoverage() {
        return insuranceCoverage;
    }

    public void setInsuranceCoverage(BigDecimal insuranceCoverage) {
        this.insuranceCoverage = insuranceCoverage;
    }

    @XmlElement
    public Boolean getOc() {
        return oc;
    }

    public void setOc(Boolean oc) {
        this.oc = oc;
    }


    public static Builder builder() {
        return new Insurance.Builder(new Insurance());
    }

    public static class Builder {

        private final Insurance insurance;

        public Builder(Insurance insurance) {
            this.insurance = insurance;
        }

        public Builder policeNumber(String policeNumber) {
            this.insurance.policeNumber = policeNumber;
            return this;
        }

        public Builder insuredFrom(LocalDate insuredFrom) {
            this.insurance.insuredFrom = insuredFrom;
            return this;
        }

        public Builder insuredTill(LocalDate insuredTill) {
            this.insurance.insuredTill = insuredTill;
            return this;
        }

        public Builder insuranceCoverage(BigDecimal insuranceCoverage) {
            this.insurance.insuranceCoverage = insuranceCoverage;
            return this;
        }

        public Builder oc(Boolean oc) {
            this.insurance.oc = oc;
            return this;
        }

        public Insurance build() {
            return this.insurance;
        }

    }

    @Override
    public String toString() {
        return String.format("Insurance{id=%d, policeNumber='%s', insuredFrom=%s, insuredTill=%s, coverage=%s, oc=%s}",
                id, policeNumber, insuredFrom, insuredTill, insuranceCoverage, oc);
    }
}
