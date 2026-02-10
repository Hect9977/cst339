package com.gcu.data;

import java.util.List;

// This is the Data Access Interface that will be used by the Service Layer to interact with the database
public interface DataAccessInterface<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}
