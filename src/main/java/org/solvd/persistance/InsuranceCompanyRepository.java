package org.solvd.persistance;

import org.solvd.domain.services.InsuranceCompany;

import java.sql.SQLException;

public interface InsuranceCompanyRepository extends CrudRepository<InsuranceCompany> {

    InsuranceCompany create(InsuranceCompany insuranceCompany);
}
