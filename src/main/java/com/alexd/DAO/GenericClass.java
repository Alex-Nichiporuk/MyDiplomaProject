package com.alexd.DAO;


import com.alexd.util.man.EntManager;

import java.util.List;

public abstract class GenericClass<T> implements GenericDao<T> {

    private final Class<T> type;



     GenericClass(Class<T> type) {
        this.type = type;
    }

    private Class<T> getMyType() {
        return this.type;
    }

    public void insert(T entity) {
        EntManager.getManager().persist(entity);
    }

    public void update(T entity) {
        EntManager.getManager().merge(entity);
    }

    public Object findById(Object id) {

        Object result = EntManager.getManager().find(this.getMyType(),id);
        return result;
    }




    public void delete(Object id) {
        T entity = (T)this.findById(id);
        EntManager.getManager().remove(entity);
        }










}
