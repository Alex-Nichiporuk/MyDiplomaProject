package com.alexd.service;

import com.alexd.DAO.GenericClass;
import com.alexd.DAO.GenericDao;
import com.alexd.util.man.EntManager;

import javax.persistence.EntityManager;

/**
 * Created by Cj444 on 14.10.2016.
 */
public class GenericService<T> implements GenericServiceImpl<T>{
    GenericDao<T> bindDao = new GenericClass<T>();

    public boolean add(T entity)
    {

        EntityManager em = EntManager.getManager().createEntityManager();
        try
        {
            em.getTransaction().begin();
            bindDao.insert(entity);
            em.getTransaction().commit();
        }
        catch (Exception exc)
        {
            return false;
        }

        return true;
    }

}
