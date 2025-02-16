package org.solvd.service.impl;

import org.solvd.domain.services.InsuranceCompany;
import org.solvd.persistance.InsuranceCompanyRepository;
import org.solvd.persistance.impl.InsuranceCompanyMapperImp;
import org.solvd.persistance.impl.InsuranceCompanyRepositoryImpl;
import org.solvd.service.InsuranceCompanyService;

import java.util.List;

public class InsuranceCompanyServiceImp implements InsuranceCompanyService {

    private final InsuranceCompanyRepository insuranceCompanyRepository;

    public InsuranceCompanyServiceImp() {
        this.insuranceCompanyRepository = new InsuranceCompanyMapperImp();
//        this.insuranceCompanyRepository = new InsuranceCompanyRepositoryImpl();
    }

    @Override
    public InsuranceCompany create(InsuranceCompany insuranceCompany) {
        insuranceCompany.setId(null);

        insuranceCompanyRepository.create(insuranceCompany);
        return insuranceCompany;


    }

    @Override
    public InsuranceCompany retrieveById(Long id) {

        return insuranceCompanyRepository.findById(id).orElse(null);

    }

    @Override
    public List<InsuranceCompany> retrieveAll() {

        return insuranceCompanyRepository.findAll();


    }

    @Override
    public InsuranceCompany update(InsuranceCompany insuranceCompany) {

        insuranceCompanyRepository.update(insuranceCompany);
        return insuranceCompany;

    }

    @Override
    public void deleteById(Long id) {

        insuranceCompanyRepository.deleteById(id);


    }
}
