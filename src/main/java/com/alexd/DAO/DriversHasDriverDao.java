package com.alexd.DAO;


import com.alexd.model.DriversHasDriverEntity;

import java.sql.Timestamp;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class DriversHasDriverDao extends GenericClass {
    DriversHasDriverEntity e;

    public DriversHasDriverDao() {
        super( DriversHasDriverEntity.class);
    }

    private void setEntity(int driver_id, int drivers_id, Timestamp worktime)
    {
        e = new DriversHasDriverEntity();
        e.setDriverId(driver_id);
        e.setDriversId(drivers_id);
        e.setWorkTime(worktime);
    }

    private void setEntity(int id,int driver_id, int drivers_id, Timestamp worktime)
    {
        e = new DriversHasDriverEntity();
        e.setDriverId(driver_id);
        e.setDriversId(drivers_id);
        e.setWorkTime(worktime);
        e.setId(id);
    }

    public int addDriversHasDrive(int driver_id, int drivers_id, Timestamp worktime)
    {
        setEntity(  driver_id,   drivers_id,   worktime);
        this.insert(e);
        return e.getId();
    }




    public void updateDriversHasDrive(int id,int driver_id, int drivers_id, Timestamp worktime)
    {
        setEntity(  id,driver_id,   drivers_id,   worktime);
        this.update(e);

    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
