package com.alexd.app;



//import com.alexd.DAO.MapDao;


import com.alexd.DAO.CargoDao;
import com.alexd.DAO.DriverDao;
import com.alexd.DAO.MapDao;
import com.alexd.model.CargoEntity;
import com.alexd.model.DriverEntity;
import com.alexd.model.MapEntity;
import com.alexd.service.DriverService;
import com.alexd.service.OrderService;
import com.alexd.service.TruckService;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.DriverView;
import com.alexd.view.util.TruckView;
import com.sun.jmx.snmp.Timestamp;

import java.util.ArrayList;

public class App
{


    public static void main( String[] args )
    {

        OrderService od = new OrderService();
      ArrayList<String>test =  od.checkCargoPath(100);
System.exit(0);

    }




}
