package org.solvd.domain.staff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.solvd.domain.accident.Accident;
import org.solvd.domain.accident.AccidentListener;
import org.solvd.domain.accident.Vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Client extends Person implements AccidentListener {

    private Long clientId;
    private BigDecimal discount;
    private List<Vehicle> vehicles;

    public Client() {
    }

    @Override
    public Long getPersonId() {
        return super.getPersonId();
    }

    @Override
    public void setPersonId(Long personId) {
        super.setPersonId(personId);
    }

    @XmlElement
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @XmlElement
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @XmlElementWrapper(name = "vehicles")
    @XmlElement(name = "Vehicle")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public void call() {
        System.out.println("Calling client " + getName() + " " + getSurname());
    }

    @Override
    public void onNewAccident(Accident accident) {
        System.out.println("New accident happened, we decrease your discount by 5€. Accident info -> " + accident);
        discount = discount.subtract(BigDecimal.valueOf(5));
    }


    @Override
    public String toString() {
        return String.format("%nClient{id=%d, discount='%s', vehicles=%s, %s}",
                clientId, discount, vehicles, super.toString());
    }
}
