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

    private void setEntity(int id, String truck_id, int truckplan_id)
    {
        e = new TruckHasTruckplanEntity();
        e.setTruckId(truck_id);
        e.setTruckPlanId(truckplan_id);
        e.setId(id);
    }

    public int addTruckHasTruckPlan(String truck_id, int truckplan_id)
    {
        setEntity(  truck_id,   truckplan_id);
        this.insert(e);
        return e.getId();
    }




    public void updateTruckHasTruckPlan(int id, String truck_id, int truckplan_id)
    {
        setEntity( id, truck_id,   truckplan_id);
        this.update(e);

    }


}
