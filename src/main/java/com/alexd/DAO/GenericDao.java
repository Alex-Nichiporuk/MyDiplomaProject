package com.alexd.DAO;


import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Cj444 on 03.10.2016.
 */
public interface GenericDao<T> {

     void insert(T entity);
     void update(T entity);
     Object findById(Object id);
     void delete(T entity);



}
