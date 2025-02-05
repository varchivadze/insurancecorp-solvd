package org.solvd.domain.staff;

import java.math.BigDecimal;

public class Employee extends Person {

    private Long employeeId;
    private String position;
    private BigDecimal salary;
    private BigDecimal bonus;
    private String passportId;

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
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

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }


    @Override
    public String toString() {
        return String.format("%nEmployee{id=%d, position='%s', salary=%s, bonus=%s, passportId='%s', %s}",
                employeeId, position, salary, bonus, passportId, super.toString());
    }
}
