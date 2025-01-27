package org.solvd.persistance.impl;

import org.solvd.persistance.ConnectionPool;
import org.solvd.persistance.InsuranceCompanyRepository;

public class InsuranceCompanyRepositoryImpl  implements InsuranceCompanyRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String GET_ALL_QUERY =
}
