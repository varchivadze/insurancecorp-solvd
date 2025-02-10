package org.solvd.domain.accident;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.solvd.domain.services.Insurance;
import org.solvd.domain.staff.Person;
import org.solvd.service.YearAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Year;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Vehicle {

    private Long id;

    @JsonProperty("Person")
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

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "Person")
    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @XmlElement
    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlElement
    @XmlJavaTypeAdapter(YearAdapter.class)
    public Year getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(Year yearProduced) {
        this.yearProduced = yearProduced;
    }

    @XmlElement
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @XmlElement
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @XmlElement
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @XmlElementWrapper(name = "insurances")
    @XmlElement(name = "Insurance")
    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    @Override
    public String toString() {
        return String.format("Vehicle{id=%d, owner=%s, made='%s', model='%s', yearProduced=%s, plateNumber='%s', vin='%s', seats=%d, insurances=%s}",
                id, owner, made, model, yearProduced, plateNumber, vin, seats, insurances);
    }
}
