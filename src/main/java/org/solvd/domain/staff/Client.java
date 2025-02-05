package org.solvd.domain.staff;

import org.solvd.domain.accident.Vehicle;

import java.math.BigDecimal;
import java.util.List;


public class Client extends Person {

    private Long clientId;
    private BigDecimal discount;
    private List<Vehicle> vehicles;

    public Client() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

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
