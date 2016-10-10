package com.alexd.DAO;

import com.alexd.model.TruckEntity;

/**
 * Created by Cj444 on 10.10.2016.
 */
public class TruckDao extends GenericClass {

    public TruckDao() {
        super( TruckEntity.class);
    }


    public boolean addTruck(String id, int size, byte status, int city)
    {
        try{
            TruckEntity e = new TruckEntity();
            e.setMapId(city);
            e.setId(id);
            e.setSize(size);
            e.setStatus(status);
            this.beginTransaction();
            this.insert(e);
            this.commitTransaction();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;


    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
