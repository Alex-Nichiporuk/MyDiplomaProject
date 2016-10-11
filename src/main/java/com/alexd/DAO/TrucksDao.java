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

    public int addTrucks(int count, int size)
    {
        setEntity(   count,   size);
        this.insert(e);
        return e.getId();
    }


    public void deleteTrucks(int count, int size)
    {
        setEntity(   count,   size);
        this.delete(e);

    }

    public void updateTrucks(int count, int size)
    {
        setEntity(   count,   size);
        this.update(e);

    }

    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
