package com.alexd.DAO;


import com.alexd.util.man.EntManager;

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

    public Object findById(int id) {

        Object ent = EntManager.getManager().find(this.getMyType(),id);
        return ent;
    }

    public abstract Object findByMaxId();


    public void delete(Object entity) {
        EntManager.getManager().remove(entity);
        }


    public  void beginTransaction() {
        EntManager.getManager().getTransaction().begin();
    }

    public  void closeEm() {
        EntManager.getManager().close();
    }

    public  void commitTransaction() {
        EntManager.getManager().getTransaction().commit();
    }






}
