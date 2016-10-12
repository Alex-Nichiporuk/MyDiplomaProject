package com.alexd.DAO;


import com.alexd.model.DriverEntity;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.DriverView;
import com.alexd.view.util.ListToView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.metamodel.ListAttribute;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 08.10.2016.
 */
public class DriverDao  extends GenericClass {
    DriverEntity e;

        public DriverDao() {
            super(DriverEntity.class);
        }





    private void setEntity(String name, String lastname, int city)
    {

         e = new DriverEntity();
        e.setName(name);
        e.setLastName(lastname);
        e.setStatus(0);
        e.setMapId(city);
        e.setTimeStatus(new Timestamp(1000l));
    }

    private void setEntity(int id, String name, String lastname, int city)
    {
        e = new DriverEntity();
        e.setName(name);
        e.setLastName(lastname);
        e.setStatus(0);
        e.setMapId(city);
        e.setId(id);
        e.setTimeStatus(new Timestamp(1000l));

    }


    public int addDriver(String name, String lastname, int city)
    {
        setEntity( name,  lastname,  city);
        this.insert(e);
        return e.getId();
    }




    public void updateDriver(int id, String name, String lastname, int city)
    {
        setEntity(id, name,  lastname,  city);
        this.update(e);

    }

    public void updateTime(int id, Timestamp ts)
    {

       e =  (DriverEntity)this.findById(id);
        e.setTimeStatus(new Timestamp(e.getTimeStatus().getTime()+ts.getTime()));
        this.update(e);
    }

    public ArrayList<DriverView> selectAll(EntityManager em)
    {
        String query = "SELECT  d.id, d.map_id, d.name , d.lastname, d.current_truck, d.time_status, m.city, d.status  FROM Driver d JOIN Map m ON d.map_id = m.id  ;";
       Query resultQuery = em.createNativeQuery(query);
      List<Object[]> a =  resultQuery.getResultList();

       return ListToView.listToDriverList(a);

    }





}
