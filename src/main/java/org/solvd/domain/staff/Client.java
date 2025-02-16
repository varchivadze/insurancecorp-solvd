package org.solvd.domain.staff;

import org.solvd.domain.accident.Vehicle;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Client extends Person {

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
    public String toString() {
        return String.format("%nClient{id=%d, discount='%s', vehicles=%s, %s}",
                clientId, discount, vehicles, super.toString());
    }
}
