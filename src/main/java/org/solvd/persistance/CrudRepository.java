package org.solvd.persistance;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    void update(T address);

    void deleteById(Long id);

}
