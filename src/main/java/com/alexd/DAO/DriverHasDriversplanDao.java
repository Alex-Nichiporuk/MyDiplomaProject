package com.alexd.DAO;

import com.alexd.model.DriverHasDriversplanEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class DriverHasDriversplanDao extends GenericClass {

    DriverHasDriversplanEntity e;

    public DriverHasDriversplanDao() {
        super( DriverHasDriversplanEntity.class);
    }

    private void setEntity(int driver_id, int driversplan_id)
    {
        e = new DriverHasDriversplanEntity();
        e.setDriverId(driver_id);
        e.setDriversPlanId(driversplan_id);
    }

    private void setEntity(int id, int driver_id, int driversplan_id)
    {
        e = new DriverHasDriversplanEntity();
        e.setDriverId(driver_id);
        e.setDriversPlanId(driversplan_id);
        e.setId(id);
    }

    public int addDriverHasDriversplan(int driver_id, int driversplan_id)
    {
        setEntity(  driver_id,   driversplan_id);
        this.insert(e);
        return e.getId();
    }




    public void updateDriverHasDriversplan(int id, int driver_id, int driversplan_id)
    {
        setEntity(  id,  driver_id,   driversplan_id);
        this.update(e);

    }




}
