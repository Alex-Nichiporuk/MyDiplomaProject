package com.alexd.service;
import com.alexd.view.util.DriverView;
import java.util.List;

/**
 * Created by Cj444 on 14.10.2016.
 */
public interface DriverServiceImpl {
     int addDriver(String name, String lastname, int city);
  boolean updateDriver(int id, String name, String lastname, int city);
      List<DriverView> selectAll();
  }
