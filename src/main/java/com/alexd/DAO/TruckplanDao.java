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
    public int addTruckplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(   begin ,   end);
        this.insert(e);
        return e.getId();
    }


    public void deleteTruckplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(   begin ,   end);
        this.delete(e);

    }

    public void updateTruckplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(   begin ,  end);
        this.update(e);

    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
