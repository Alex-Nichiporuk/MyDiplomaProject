package com.alexd.service;

import com.alexd.DAO.DriverDao;
import com.alexd.model.DriverEntity;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.DriverView;
//import com.alexd.DAO.MapDao;

import javax.persistence.EntityManager;
import java.awt.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;

/**
 * Created by Cj444 on 09.10.2016.
 */
public class DriverService {
EntityManager em;
    DriverDao driverDao;
    public DriverService()
    {
        em = EntManager.getManager();
        driverDao = new DriverDao();
    }

    public int addDriver(String name, String lastname, int city)
    {
        int id;
        try {
            em.getTransaction().begin();
        id =   driverDao.addDriver(name , lastname, city);
            em.getTransaction().commit();

        }
        catch (Exception e)
        {
            return -1;
        }
      return  id;
    }

    public boolean updateDriver(int id, String name, String lastname, int city)
    {
        try {
            em.getTransaction().begin();
            driverDao.updateDriver(id, name, lastname, city);
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
        List<DriverView> resultQuery = driverDao.selectAll(em);
        em.getTransaction().commit();
        ArrayList<DriverView> result = new ArrayList(resultQuery);
        return result;
    }
    catch (Exception e)
    {
        return null;
    }


}







}