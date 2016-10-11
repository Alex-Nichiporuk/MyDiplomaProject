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

    public int addDriverHasDriversplan(int driver_id, int driversplan_id)
    {
        setEntity(  driver_id,   driversplan_id);
        this.insert(e);
        return e.getId();
    }


    public void deleteDriverHasDriversplan(int driver_id, int driversplan_id)
    {
        setEntity(  driver_id,   driversplan_id);
        this.delete(e);

    }

    public void updateDriverHasDriversplan(int driver_id, int driversplan_id)
    {
        setEntity(  driver_id,   driversplan_id);
        this.update(e);

    }




    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
