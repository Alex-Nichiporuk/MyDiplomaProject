package com.alexd.DAO;

import com.alexd.model.DriversEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class DriversDao extends GenericClass {
    DriversEntity e;
    public DriversDao() {
        super(DriversEntity.class);
    }




    private void setEntity(int size, String truck)
    {
        e = new DriversEntity();
        e.setSize(size);
        e.setTruckId(truck);
    }
    public int addDrivers(int size, String truck)
    {
        setEntity(   size,   truck);
        this.insert(e);
        return e.getId();
    }


    public void deleteDrivers(int size, String truck)
    {
        setEntity(   size,   truck);
        this.delete(e);

    }

    public void updateDrivers(int size, String truck)
    {
        setEntity(   size,   truck);
        this.update(e);

    }








    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
