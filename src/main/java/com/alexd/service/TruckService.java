package com.alexd.service;

import com.alexd.DAO.TruckDao;
import com.alexd.model.TruckEntity;
import com.alexd.view.util.TruckView;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckService implements TruckServiceImpl{
    EntityManager em;
    TruckDao truckDao;
    public TruckService()
    {
                 truckDao = new TruckDao();
    }


    public String addTruck(String id, int size, int city, boolean status, int driversize)
    {

        TruckEntity truckEntity = new TruckEntity(id, size,status, city, driversize );
        GenericService<TruckEntity>genericService = new GenericService<TruckEntity>();
        genericService.add(truckEntity);
        return  truckEntity.getId();
    }

    public boolean updateTruck(String id, int size, int city, boolean status, int driversize)
    {
        try {
            em.getTransaction().begin();
            truckDao.update(new TruckEntity(id, size,status,  driversize ,city ));
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private List<TruckEntity> selectAlldao()
    {
        try {
            em.getTransaction().begin();
            List<TruckEntity> resultQuery = truckDao.selectAll(em);
            em.getTransaction().commit();

            return resultQuery;
        }
        catch (Exception e)
        {
            return null;
        }


    }

    public ArrayList<TruckView> selectAll()
    {
        ArrayList<TruckView> truckViews = new ArrayList<TruckView>();
        List<TruckEntity> truckEntities = selectAlldao();
        for(TruckEntity truckEntity : truckEntities)
        {
            truckViews.add(new TruckView(truckEntity));
        }
        return truckViews;
    }



}
