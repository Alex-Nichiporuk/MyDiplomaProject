package com.alexd.DAO;


import com.alexd.model.*;
import com.alexd.util.man.EntManager;

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



    public List<DriverEntity>selectAll()
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        TypedQuery<DriverEntity> q = em.createQuery("select  d FROM DriverEntity as d" ,DriverEntity.class);
      List<DriverEntity> result =  q.getResultList();
  return result;

    }









    public List<DriverEntity>getDriversByOrder(int order)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query = "select  d FROM DriverEntity as d , DriversdescEntity  as de, OrdersEntity as o WHERE d.id=de.driverId AND de.descId = o.driverDescId AND o.id="+order;
        TypedQuery<DriverEntity> q = em.createQuery( query ,DriverEntity.class);
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

    public OrdersEntity getOrder ( int driverId)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String query = "select  o from OrdersEntity AS o, DriversdescEntity  as de, DriverEntity  as d WHERE o.driverDescId =de.descId AND de.driverId = d.id AND o.status = false AND d.id="+driverId;
        TypedQuery<OrdersEntity> q = em.createQuery( query ,OrdersEntity.class);
        List<OrdersEntity> result =  q.getResultList();

        return result.size()>0?result.get(0):null;
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

    public List<DriverEntity>getByDif(String code)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        String param = "'"+code+"%'";
        String query = "SELECT d FROM DriverEntity AS d  WHERE d.lastName LIKE"+ param + " OR d.name LIKE"+param ;
        TypedQuery<DriverEntity> q = em.createQuery( query ,DriverEntity.class);


        List<DriverEntity> a = q.getResultList();
        return q.getResultList();
    }


public int getDoneOrder(int id)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    String query = "SELECT o FROM OrdersEntity AS o , DriversdescEntity AS dd , DriverEntity as d WHERE  o.driverDescId = dd.descId AND  dd.driverId = d.id AND o.status= true AND d.id="+id;
    TypedQuery<OrdersEntity> q = em.createQuery( query ,OrdersEntity.class);
    List<OrdersEntity> a = q.getResultList();
    return a.size();
}

public   List<PathEntity> getPathLengthStat(int id)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    String query = "SELECT p FROM PathEntity AS p , DriversdescEntity AS dd , DriverEntity as d  , OrdersEntity AS o WHERE o.driverDescId = dd.descId AND  dd.driverId = d.id AND  p.id = o.pathId AND d.id="+id;
    TypedQuery<PathEntity> q = em.createQuery( query ,PathEntity.class);
    List<PathEntity> a = q.getResultList();
    return a;

}

public List<CargoEntity> getWeightStat(int id)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    String query = "SELECT c FROM PointEntity AS point , PointHasCargoEntity AS h, PathEntity AS p , CargoEntity AS c , DriversdescEntity AS dd , DriverEntity as d  , OrdersEntity AS o WHERE point.pathId = p.id AND h.pointId = point.id AND h.cargoId = c.id AND o.driverDescId = dd.descId AND  dd.driverId = d.id AND  p.id = o.pathId AND d.id="+id;
    TypedQuery<CargoEntity> q = em.createQuery( query ,CargoEntity.class);
    List<CargoEntity> a = q.getResultList();
    return a;

}

public List<DriversplanEntity> getTimeStat(int id)
    {

        EntityManager em = EntManager.getManager().createEntityManager();
        String query = "SELECT tp FROM DriversplanEntity AS tp , DriverEntity AS d WHERE d.id = tp.driverId  AND d.id="+id;
        TypedQuery<DriversplanEntity> q = em.createQuery( query ,DriversplanEntity.class);
        List<DriversplanEntity> a = q.getResultList();
        return a;
    }

}
