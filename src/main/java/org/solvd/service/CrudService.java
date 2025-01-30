package org.solvd.service;

import java.util.List;

public interface CrudService<T> {


    T retrieveById(Long id);

    List<T> retrieveAll();

    T update(T employee);

    void deleteById(Long id);
}
