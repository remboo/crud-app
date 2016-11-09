package com.johnremboo.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
    boolean add(T object);
    void delete(int id);
    void update(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;

    void closeConnection();
}
