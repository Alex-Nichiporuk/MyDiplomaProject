package com.alexd.view.util;

import com.alexd.model.DriverEntity;
import com.alexd.model.OrdersEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cj444 on 14.10.2016.
 */
public class DriverUIView {

    int id;
    String name;
    String lastname;
    HashMap<Integer , String> coDriver;
    String truckId;
    int orderId;
   ArrayList<PointView>pointViews;
    public DriverUIView(DriverEntity driverEntity, OrdersEntity ordersEntity, ArrayList<PointView>pointViews, HashMap<Integer , String> coDriver )
    {
        this.id = driverEntity.getId();
        this.truckId = ordersEntity.getTruckId();
        this.orderId = ordersEntity.getId();
        this.name = driverEntity.getName();
        this.lastname = driverEntity.getLastName();
        this.pointViews = pointViews;
        this.coDriver = coDriver;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public HashMap<Integer, String> getCoDriver() {
        return coDriver;
    }

    public String getTruckId() {
        return truckId;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<PointView>getPointViews() {
        return pointViews;
    }
}
