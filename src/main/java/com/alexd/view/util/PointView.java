package com.alexd.view.util;

/**
 * Created by Cj444 on 15.10.2016.
 */
public class PointView {
    String city;
    String cargo;
    Float weight;
    boolean status;

    public PointView(String city, String cargo, Float weight, boolean status) {
        this.city = city;
        this.cargo = cargo;
        this.weight = weight;
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public String getCargo() {
        return cargo;
    }

    public Float getWeight() {
        return weight;
    }

    public boolean isStatus() {
        return status;
    }
}
