package com.alexd.DAO;

import com.alexd.model.TruckEntity;
import com.alexd.view.util.ListToView;
import com.alexd.view.util.TruckView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 10.10.2016.
 */
public class TruckDao extends GenericClass {
    TruckEntity e;
    public TruckDao() {
        super( TruckEntity.class);
    }





    private void setEntity(String id, int size, boolean status, int city)
    {
        e = new TruckEntity();
        e.setMapId(city);
        e.setId(id);
        e.setSize(size);
        e.setStatus(status);
    }



    public String addTruck(String id, int size, boolean status, int city)
    {
        setEntity(   id,   size,   status,   city);
        this.insert(e);
        return e.getId();
    }




    public void updateTruck(String id, int size, boolean status, int city)
    {
        setEntity(   id,   size,   status,   city);
        this.update(e);

    }

    public ArrayList<TruckView> selectAll(EntityManager em)
    {
        String query = "SELECT  t.id,  t.size, t.status, t.driver_desc, t.map_id, m.city FROM Truck t JOIN Map m ON t.map_id = m.id  ;";
        Query resultQuery = em.createNativeQuery(query);
        List<Object[]> a =  resultQuery.getResultList();

        return ListToView.listToTruckList(a);

    }



}
