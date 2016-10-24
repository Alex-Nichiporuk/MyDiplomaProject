package com.alexd.view.util;

/**
 * Created by Cj444 on 22.10.2016.
 */
public class DriverStatView {
    int orders;
    double path;
    long time;
    float weight;

    public DriverStatView(int orders, double path, long time, float weight) {
        this.orders = orders;
        this.path = path;
        this.time = time;
        this.weight = weight;
    }
}
