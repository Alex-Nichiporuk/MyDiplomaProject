package com.alexd.view.util;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckView {
    String id;
    float size;
    boolean status;
    int driverdesc;
    int map_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDriverdesc() {
        return driverdesc;
    }

    public void setDriverdesc(int driverdesc) {
        this.driverdesc = driverdesc;
    }

    public int getMap_id() {
        return map_id;
    }

    public void setMap_id(int map_id) {
        this.map_id = map_id;
    }
}
