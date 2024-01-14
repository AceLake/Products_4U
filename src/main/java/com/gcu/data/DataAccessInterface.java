package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public interface DataAccessInterface <T> {

    public List<T> findAll();
    public T findById(Long id);
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(T t);
 
}
