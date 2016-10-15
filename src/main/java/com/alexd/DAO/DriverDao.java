package com.alexd.DAO;


import com.alexd.model.DriverEntity;
import com.alexd.model.OrdersEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cj444 on 08.10.2016.
 */
public class DriverDao  extends GenericClass<DriverEntity> implements DriverImpl{
     final private long maxPeriod = 633600000;

   public DriverDao() {
            super(DriverEntity.class);
        }



    public List<DriverEntity>selectAll(EntityManager em)
    {
        TypedQuery<DriverEntity> q = em.createQuery("select  d FROM DriverEntity as d" ,DriverEntity.class);
      List<DriverEntity> result =  q.getResultList();
  return result;

    }

    public HashMap<Integer , String>getCodriver(int order, EntityManager em)
    {
        String query = "select  d FROM DriverEntity as d , DriversdescEntity  as de, OrdersEntity as o WHERE d.id=de.driverId AND de.descId = o.driverDescId AND o.id="+order;
        TypedQuery<DriverEntity> q = em.createQuery( query ,DriverEntity.class);
        List<DriverEntity> result =  q.getResultList();
        HashMap<Integer , String> resultMap = new HashMap<Integer, String>();
        for(DriverEntity a:result)
        {
            resultMap.put(a.getId(),a.getLastName()+" "+a.getName());
        }
        return resultMap;


    }

    public OrdersEntity getOrder ( int driverId, EntityManager em)
    {
        String query = "select  o from OrdersEntity AS o, DriversdescEntity  as de, DriverEntity  as d WHERE o.driverDescId =de.descId AND de.driverId = d.id AND o.status = false AND d.id="+driverId;
        TypedQuery<OrdersEntity> q = em.createQuery( query ,OrdersEntity.class);
        List<OrdersEntity> result =  q.getResultList();
        return result.get(0);
    }


    public List<DriverEntity>getDriverForOrder( long workPeriod, String truck,  EntityManager em)
    {
        String query = "SELECT d FROM DriverEntity AS d , TruckEntity AS tr WHERE d.mapId = tr.mapId   AND d.status = 0   AND (d.timeStatus+?)<? AND tr.id=?";
        TypedQuery<DriverEntity> q = em.createQuery( query ,DriverEntity.class);

        q.setParameter(0,workPeriod);
        q.setParameter(2,truck);
        q.setParameter(1,maxPeriod);
        return q.getResultList();
    }





}
