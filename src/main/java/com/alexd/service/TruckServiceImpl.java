package com.alexd.service;

import com.alexd.view.util.TruckView;

import java.util.ArrayList;

/**
 * Created by Cj444 on 14.10.2016.
 */
public interface TruckServiceImpl {



      String addTruck(String id, int size, int city, boolean status, int driversize);
      boolean updateTruck(String id, float size, int city, String status, int driversize);
      ArrayList<TruckView> selectAll();





}
