package com.alexd.service;

import com.alexd.DAO.TruckDao;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.TruckView;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckService {
    EntityManager em;
    TruckDao truckDao;
    public TruckService()
    {
        em = EntManager.getManager();
        truckDao = new TruckDao();
    }


    public String addTruck(String id, int size, int city, boolean status)
    {
    String truck_id;
        try {
            em.getTransaction().begin();
            truck_id =   truckDao.addTruck(id, size, status,city);
            em.getTransaction().commit();

        }
        catch (Exception e)
        {
            return null;
        }
        return  truck_id;
    }

    public boolean updateTruck(String id, int size, int city, boolean status)
    {
        try {
            em.getTransaction().begin();
            truckDao.updateTruck(id,size,status,city);
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public ArrayList selectAll()
    {
        try {
            em.getTransaction().begin();
            List<TruckView> resultQuery = truckDao.selectAll(em);
            em.getTransaction().commit();
            ArrayList<TruckView> result = new ArrayList(resultQuery);
            return result;
        }
        catch (Exception e)
        {
            return null;
        }


    }

}
