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

    public int addDriversHasDrive(int driver_id, int drivers_id, Timestamp worktime)
    {
        setEntity(  driver_id,   drivers_id,   worktime);
        this.insert(e);
        return e.getId();
    }


    public void deleteDriversHasDrive(int driver_id, int drivers_id, Timestamp worktime)
    {
        setEntity(  driver_id,   drivers_id,   worktime);
        this.delete(e);

    }

    public void updateDriversHasDrive(int driver_id, int drivers_id, Timestamp worktime)
    {
        setEntity(  driver_id,   drivers_id,   worktime);
        this.update(e);

    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
