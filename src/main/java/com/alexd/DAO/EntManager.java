package com.alexd.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Cj444 on 03.10.2016.
 */
public class EntManager {

static EntityManagerFactory entityManagerFactory;
  static EntityManager em;


public static EntityManager getManager()
{
    if(em != null)
    {
        return em;
    }
    else
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("truckApp");
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }


}

}
