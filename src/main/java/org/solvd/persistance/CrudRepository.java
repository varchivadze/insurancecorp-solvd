package org.solvd.persistance;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    void create(T address)throws SQLException;

    Optional<T> findById(Long id)throws SQLException;

    List<T> findAll()throws SQLException;

    void update(T address)throws SQLException;

    void deleteById(Long id)throws SQLException;
}
