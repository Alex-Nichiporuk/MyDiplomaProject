package com.alexd.DAO;

import com.alexd.model.TruckEntity;

/**
 * Created by Cj444 on 10.10.2016.
 */
public class TruckDao extends GenericClass {
    TruckEntity e;
    public TruckDao() {
        super( TruckEntity.class);
    }





    private void setEntity(String id, int size, byte status, int city)
    {
        e = new TruckEntity();
        e.setMapId(city);
        e.setId(id);
        e.setSize(size);
        e.setStatus(status);
    }

    public String addTruck(String id, int size, byte status, int city)
    {
        setEntity(   id,   size,   status,   city);
        this.insert(e);
        return e.getId();
    }


    public void deleteTruck(String id, int size, byte status, int city)
    {
        setEntity(   id,   size,   status,   city);
        this.delete(e);

    }

    public void updateTruck(String id, int size, byte status, int city)
    {
        setEntity(   id,   size,   status,   city);
        this.update(e);

    }



    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
