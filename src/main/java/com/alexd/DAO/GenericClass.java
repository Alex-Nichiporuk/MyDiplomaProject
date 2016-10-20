package com.alexd.DAO;


import com.alexd.util.man.EntManager;

import javax.persistence.EntityManager;


public  class GenericClass<T> implements GenericDao<T> {

    private  Class<T> type = null;


 public    GenericClass() { }
     GenericClass(Class<T> type) {
        this.type = type;
    }

    private Class<T> getMyType() {
        return this.type;
    }

    public void insert(T entity) {
        EntityManager em = EntManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(T entity) {
        EntManager.getManager().createEntityManager().merge(entity);
    }

    public Object findById(Object id) {

        Object result = EntManager.getManager().createEntityManager().find(this.getMyType(),id);
        return result;
    }





    public void delete(Object id) {
        T entity = (T)this.findById(id);
        EntManager.getManager().createEntityManager().remove(entity);
        }










}
