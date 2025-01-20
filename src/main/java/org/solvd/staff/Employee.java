package org.solvd.staff;

import java.math.BigDecimal;

public class Employee extends Person {

    private Positions position;
    private BigDecimal salary;
    private BigDecimal bonus;
    private String passportId;

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public Employee(long id) {
        super(id);
        this.salary = BigDecimal.ZERO;
        this.bonus = BigDecimal.ZERO;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }
}
