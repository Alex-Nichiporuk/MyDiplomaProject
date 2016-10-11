package com.alexd.DAO;

import com.alexd.model.TrucksEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TrucksDao extends GenericClass {
    TrucksEntity e;
    public TrucksDao() {
        super(TrucksEntity.class);
    }





    private void setEntity(int count, int size)
    {
        e = new TrucksEntity();
        e.setSize(size);
        e.setCountTrucks(count);
    }

    private void setEntity(int id, int count, int size)
    {
        e = new TrucksEntity();
        e.setSize(size);
        e.setCountTrucks(count);
        e.setId(id);
    }

    public int addTrucks(int count, int size)
    {
        setEntity(   count,   size);
        this.insert(e);
        return e.getId();
    }




    public void updateTrucks(int id, int count, int size)
    {
        setEntity(id,   count,   size);
        this.update(e);

    }


}
