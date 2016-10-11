package com.alexd.DAO;

import com.alexd.model.DriversplanEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class DriversplanDao extends GenericClass {
    DriversplanEntity driversplanEntity;
    public DriversplanDao() {
        super(DriversplanEntity.class);
    }





    private void setEntity(java.sql.Timestamp begin , java.sql.Timestamp end) {
        driversplanEntity = new DriversplanEntity();
        driversplanEntity.setBegin(begin);
        driversplanEntity.setEnd(end);
    }

    public int addDriversplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(     begin ,   end);
        this.insert(driversplanEntity);
        return driversplanEntity.getId();
    }


    public void deleteDriversplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity(  begin ,   end);
        this.delete(driversplanEntity);

    }

    public void updateDriversplan(java.sql.Timestamp begin , java.sql.Timestamp end)
    {
        setEntity( begin ,  end);
        this.update(driversplanEntity);

    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
