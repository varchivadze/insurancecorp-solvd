package org.solvd.domain.staff;

public interface AbstractFactory<T> {

    T create(Type type);
}
