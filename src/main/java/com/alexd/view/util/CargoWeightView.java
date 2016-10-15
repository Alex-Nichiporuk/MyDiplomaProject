package com.alexd.view.util;


import com.alexd.model.PointHasCargoEntity;

/**
 * Created by Cj444 on 14.10.2016.
 */
public class CargoWeightView {
    int pointId;
    float weight;
    boolean status;

    public CargoWeightView(PointHasCargoEntity pointHasCargoEntity)
    {
        pointId = pointHasCargoEntity.getPointId();
        weight= pointHasCargoEntity.getCargoByCargoId().getWeight();
        status = pointHasCargoEntity.getStatus();


    }

    public int getPointId() {
        return pointId;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isStatus() {
        return status;
    }
}
