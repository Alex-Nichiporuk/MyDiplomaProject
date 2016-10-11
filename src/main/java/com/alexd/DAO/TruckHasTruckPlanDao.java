package com.alexd.DAO;

import com.alexd.model.TruckHasTruckplanEntity;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckHasTruckPlanDao extends GenericClass {

    TruckHasTruckplanEntity e;

    public TruckHasTruckPlanDao() {
        super( TruckHasTruckplanEntity.class);
    }

    private void setEntity(String truck_id, int truckplan_id)
    {
        e = new TruckHasTruckplanEntity();
       e.setTruckId(truck_id);
        e.setTruckPlanId(truckplan_id);
    }

    public int addTruckHasTruckPlan(String truck_id, int truckplan_id)
    {
        setEntity(  truck_id,   truckplan_id);
        this.insert(e);
        return e.getId();
    }


    public void deleteTruckHasTruckPlan(String truck_id, int truckplan_id)
    {
        setEntity(  truck_id,   truckplan_id);
        this.delete(e);

    }

    public void updateTruckHasTruckPlan(String truck_id, int truckplan_id)
    {
        setEntity(  truck_id,   truckplan_id);
        this.update(e);

    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}
