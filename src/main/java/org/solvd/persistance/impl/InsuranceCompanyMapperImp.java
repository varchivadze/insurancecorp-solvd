package org.solvd.persistance.impl;

import org.apache.ibatis.session.SqlSession;
import org.solvd.domain.services.InsuranceCompany;
import org.solvd.persistance.InsuranceCompanyRepository;
import org.solvd.persistance.MybatisSessionHolder;

import java.util.List;
import java.util.Optional;

public class InsuranceCompanyMapperImp implements InsuranceCompanyRepository {

    @Override
    public void create(InsuranceCompany insuranceCompany) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            InsuranceCompanyRepository insuranceCompanyRepository = session.getMapper(InsuranceCompanyRepository.class);
            insuranceCompanyRepository.create(insuranceCompany);
        }
    }

    @Override
    public Optional<InsuranceCompany> findById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            InsuranceCompanyRepository insuranceCompanyRepository = session.getMapper(InsuranceCompanyRepository.class);
            return insuranceCompanyRepository.findById(id);

        }
    }

    @Override
    public List<InsuranceCompany> findAll() {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            InsuranceCompanyRepository insuranceCompanyRepository = session.getMapper(InsuranceCompanyRepository.class);
            return insuranceCompanyRepository.findAll();

        }
    }

    @Override
    public void update(InsuranceCompany insuranceCompany) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            InsuranceCompanyRepository insuranceCompanyRepository = session.getMapper(InsuranceCompanyRepository.class);
            insuranceCompanyRepository.update(insuranceCompany);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (SqlSession session = MybatisSessionHolder.getSqlSessionFactory().openSession(true)){
            InsuranceCompanyRepository insuranceCompanyRepository = session.getMapper(InsuranceCompanyRepository.class);
            insuranceCompanyRepository.deleteById(id);
        }
    }
}
