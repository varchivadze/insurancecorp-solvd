package org.solvd.service.impl;

import org.solvd.domain.services.InsuranceCompany;
import org.solvd.persistance.InsuranceCompanyRepository;
import org.solvd.persistance.impl.InsuranceCompanyRepositoryImpl;
import org.solvd.service.InsuranceCompanyService;

import java.sql.SQLException;
import java.util.List;

public class InsuranceCompanyServiceImp implements InsuranceCompanyService {

    private final InsuranceCompanyRepository insuranceCompanyRepository;

    public InsuranceCompanyServiceImp() {
        this.insuranceCompanyRepository = new InsuranceCompanyRepositoryImpl();
    }

    @Override
    public InsuranceCompany create(InsuranceCompany insuranceCompany) {
        insuranceCompany.setId(null);
        try {
            insuranceCompanyRepository.create(insuranceCompany);
            return insuranceCompany;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not handle create for insuranceCompany %s", insuranceCompany), e);
        }

    }

    @Override
    public InsuranceCompany retrieveById(Long id) {
        try {
            return insuranceCompanyRepository.findById(id).orElse(null);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Database error while retrieving insuranceCompany with id %d", id), e);
        }
    }

    @Override
    public List<InsuranceCompany> retrieveAll() {
        try {
            return insuranceCompanyRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Could not handle findAll for insuranceCompany", e);
        }

    }

    @Override
    public InsuranceCompany update(InsuranceCompany insuranceCompany) {
        try {
            insuranceCompanyRepository.update(insuranceCompany);
            return insuranceCompany;
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not update insuranceCompany %s", insuranceCompany), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            insuranceCompanyRepository.deleteById(id);
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Could not delete insuranceCompany by id %d", id), e);
        }

    }
}
