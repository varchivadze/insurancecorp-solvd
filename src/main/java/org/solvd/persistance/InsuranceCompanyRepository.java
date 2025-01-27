package org.solvd.persistance;

import org.solvd.services.InsuranceCompany;

import java.util.List;

public interface InsuranceCompanyRepository {

    void create(InsuranceCompany insuranceCompany);

    List<InsuranceCompany> getAll();
}
