package com.alexd.DAO;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cj444 on 08.10.2016.
 */
public class DriverDao  extends GenericClass<DriverEntity> implements DriverImpl{
    DriverEntity e;

   public DriverDao() {
            super(DriverEntity.class);
        }


    public void updateTime(int id, Timestamp ts)
    {

       e =  (DriverEntity)this.findById(id);
        e.setTimeStatus(new Timestamp(e.getTimeStatus().getTime()+ts.getTime()));
        this.update(e);
    }

    public List<DriverEntity>selectAll(EntityManager em)
    {
        TypedQuery<DriverEntity> q = em.createQuery("select  d FROM DriverEntity as d" ,DriverEntity.class);
      List<DriverEntity> result =  q.getResultList();
  return result;

    }

    public HashMap<Integer , String>getCodriver(int order, EntityManager em)
    {
        String query = "select  d FROM DriverEntity as d , DriversDescEntity as de, OrdersEntity as o WHERE d.id=de.driverId AND de.driversId = o.driversId AND o.id="+order;
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
        String query = "select  o from OrdersEntity AS o, DriversDescEntity  as de, DriverEntity  as d WHERE o.driversId=de.driversId AND de.driverId = d.id AND o.status = false AND d.id="+driverId;
        TypedQuery<OrdersEntity> q = em.createQuery( query ,OrdersEntity.class);
        List<OrdersEntity> result =  q.getResultList();
        return result.get(0);
    }





}
