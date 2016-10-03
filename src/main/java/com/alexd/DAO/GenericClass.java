package com.alexd.DAO;



import javax.persistence.EntityManager;



public class GenericClass<T> implements GenericDao<T> {
    EntityManager em;


    public void persist(T entity) {
        em.persist(entity);
    }

    public void update(T entity) {
em.merge(entity);
    }

    public Object findById(int id) {

        Object ent = em.find(Object.class,id);
        return ent;
    }

    public void delete(Object entity) {
em.remove(entity);
    }

    public void setEm() {
        em = EntManager.getManager();
    }

    public void beginTransaction() {
em.getTransaction().begin();
    }

    public void closeEm() {
em.close();
    }

    public void commitTransaction() {
em.getTransaction().commit();
    }
}
