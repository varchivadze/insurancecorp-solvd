package org.solvd.persistance;

import org.apache.ibatis.annotations.Param;
import org.solvd.domain.staff.Employee;

import java.sql.SQLException;

public interface EmployeeRepository extends CrudRepository<Employee> {

    void create(@Param("employee") Employee address,@Param("companyId") Long companyId);
}
