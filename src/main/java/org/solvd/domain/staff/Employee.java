package org.solvd.domain.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.solvd.domain.accident.Accident;
import org.solvd.domain.accident.AccidentListener;
import org.solvd.domain.services.Listeners;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Employee extends Person implements AccidentListener {

    private Long employeeId;
    private String position;
    private BigDecimal salary;
    private BigDecimal bonus;
    private String passportId;

    public Employee() {
    }

    @XmlElement
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @XmlElement
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlElement
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlElement
    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @XmlElement
    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    @Override
    public void call() {
        System.out.println("Calling employee " + getName() + " " + getSurname());
    }

    @Override
    public void onNewAccident(Accident accident) {
        System.out.println("New accident happened, we increase your bonus by 1€. Accident info -> " + accident);
        bonus = bonus.add(BigDecimal.ONE);
    }


    @Override
    public String toString() {
        return String.format("%nEmployee{id=%d, position='%s', salary=%s, bonus=%s, passportId='%s', %s}",
                employeeId, position, salary, bonus, passportId, super.toString());
    }
}
