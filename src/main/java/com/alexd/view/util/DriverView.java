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
    private    int city_id;

    public DriverView()
    {}

    public DriverView(int id, int city_id, String name, String lastname, String truck, Timestamp time, String city, int status)
    {

        this.name = name;
        this.lastname = lastname;
        this.truck = truck;
        this.time = time;
        this.city = city;
        this.status = status;
        this.id = id;
        this.city_id = city_id;
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
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

}
