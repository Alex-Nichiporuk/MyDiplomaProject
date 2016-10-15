package com.alexd.view.util;


import java.sql.Timestamp;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class DriverView {



    private    String name;
    private    String lastname;
    private   String truck;
    private   Timestamp time;
    private   String city;
    private   int status;
    private  int id;
    private    int cityId;


    public DriverView(DriverEntity driverEntity)
    {

        this.name = driverEntity.getName();
        this.lastname = driverEntity.getLastName();
        this.truck = driverEntity.getCurrentTruck();
        this.time = driverEntity.getTimeStatus();
        this.city = driverEntity.getMapByMapId().getCity();
        this.status = driverEntity.getStatus();
        this.id = driverEntity.getId();
        this.cityId = driverEntity.getMapId();
    }

    public int getId() {
        return id;
    }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTruck() {
        return truck;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getCity() {
        return city;
    }

    public int getStatus() {
        return status;
    }


}
