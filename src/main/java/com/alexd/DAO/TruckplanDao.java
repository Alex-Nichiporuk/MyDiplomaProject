package com.alexd.DAO;

import com.alexd.model.TruckplanEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckplanDao extends GenericClass {
    TruckplanEntity e;
    TruckplanDao( ) {
        super(TruckplanEntity.class);
    }




    private void setEntity(java.sql.Timestamp begin , java.sql.Timestamp end) {
        e = new TruckplanEntity();
        e.setBegin(begin);
        e.setEnd(end);
    }

    private void setEntity(int id, java.sql.Timestamp begin , java.sql.Timestamp end) {
        e = new TruckplanEntity();
        e.setBegin(begin);
        e.setEnd(end);
        e.setId(id);
    }
    public int addTruckplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(   begin ,   end);
        this.insert(e);
        return e.getId();
    }




    public void updateTruckplan(int id, java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(id,   begin ,  end);
        this.update(e);

    }



}
