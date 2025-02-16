package org.solvd.persistance;

import org.solvd.domain.services.InsuranceCompany;

public interface InsuranceCompanyRepository extends CrudRepository<InsuranceCompany> {

    void create(InsuranceCompany insuranceCompany);
}
