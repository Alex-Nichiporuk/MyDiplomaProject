package com.alexd.util.man;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Cj444 on 03.10.2016.
 */
public class EntManager {

static EntityManagerFactory entityManagerFactory;



public static EntityManagerFactory getManager()
{
    if(entityManagerFactory != null)
    {
        return entityManagerFactory;
    }
    else
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("truckApp");

        return entityManagerFactory;
    }


}

}
