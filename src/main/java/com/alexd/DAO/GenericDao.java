package com.alexd.DAO;



/**
 * Created by Cj444 on 03.10.2016.
 */
public interface GenericDao<T> {
    public void persist(T entity);
    public void update(T entity);
    public Object findById(int id);
    public void delete(T entity);
    public void setEm();
    public void beginTransaction();
    public void closeEm();
    public void commitTransaction();
}
