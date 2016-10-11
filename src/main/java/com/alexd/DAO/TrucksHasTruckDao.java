package com.alexd.DAO;

import com.alexd.model.TrucksHasTruckEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TrucksHasTruckDao extends GenericClass{

    TrucksHasTruckEntity e;

    public TrucksHasTruckDao() {
        super( TrucksHasTruckEntity.class);
    }

    private void setEntity(String truck_id, int trucks_id)
    {
        e = new TrucksHasTruckEntity();
         e.setTruckId(truck_id);
        e.setTrucksId(trucks_id);
    }

    public int addCargoTrucksHasTruck(String truck_id, int trucks_id)
    {
        setEntity(  truck_id,   trucks_id);
        this.insert(e);
        return e.getId();
    }


    public void deleteTrucksHasTruck(String truck_id, int trucks_id)
    {
        setEntity(  truck_id,   trucks_id);
        this.delete(e);

    }

    public void updateTrucksHasTruck(String truck_id, int trucks_id)
    {
        setEntity(  truck_id,   trucks_id);
        this.update(e);

    }
    



    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
