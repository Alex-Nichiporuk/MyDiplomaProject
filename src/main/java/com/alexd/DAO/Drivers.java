package com.alexd.DAO;

import com.alexd.model.DriversEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

/**
 * Created by Cj444 on 03.10.2016.
 */
public class Drivers implements DriversDao {
    EntityManager em;

    public void setEm()
    {
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

    public void persist(DriversEntity entity) {
em.persist(entity);
    }

    public void update(DriversEntity entity) {
em.merge(entity);
    }

    public DriversEntity findById(int id) {
        DriversEntity drv = em.find(DriversEntity.class ,id);
        return drv;
    }

    public void delete(DriversEntity entity) {

    }
}
