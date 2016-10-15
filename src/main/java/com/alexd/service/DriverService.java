package com.alexd.service;

import com.alexd.DAO.DriverDao;
import com.alexd.model.DriverEntity;
import com.alexd.view.util.DriverView;


import javax.persistence.EntityManager;
import java.util.*;
import java.util.List;

/**
 * Created by Cj444 on 09.10.2016.
 */
public class DriverService implements DriverServiceImpl {
EntityManager em;
    DriverDao driverDao;
    public DriverService()
    {
        driverDao = new DriverDao();
    }

    public int addDriver(String name, String lastname, int city)
    {
        GenericService<DriverEntity> genericService = new GenericService<DriverEntity>();
       DriverEntity de = new DriverEntity(name,lastname,city);
    genericService.add(de);
      return  de.getId();
    }

    public boolean updateDriver(int id, String name, String lastname, int city)
    {
        try {
            em.getTransaction().begin();
            driverDao.update(new DriverEntity(id,name,lastname,city));
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

private List<DriverEntity> selectAlldao()
{
    try {
        em.getTransaction().begin();
        List<DriverEntity> resultQuery = driverDao.selectAll(em);
        em.getTransaction().commit();

        return resultQuery;
    }
    catch (Exception e)
    {
        return null;
    }


}


public List<DriverView> selectAll()
{
    List<DriverEntity> driverEntities =  selectAlldao();
    List<DriverView>driverViews = new ArrayList<DriverView>();
    for(int i = 0; i<driverEntities.size();i++)
    {
        driverViews.add(new DriverView(driverEntities.get(i)));
    }
    return driverViews;
}









}