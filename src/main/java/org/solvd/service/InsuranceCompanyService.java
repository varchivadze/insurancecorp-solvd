package org.solvd.service;

import org.solvd.domain.services.InsuranceCompany;

public interface InsuranceCompanyService extends CrudService<InsuranceCompany> {

    InsuranceCompany create(InsuranceCompany t);
}
