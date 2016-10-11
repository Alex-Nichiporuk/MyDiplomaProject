package com.alexd.app;



//import com.alexd.DAO.MapDao;


import com.alexd.DAO.CargoDao;
import com.alexd.DAO.DriverDao;
import com.alexd.DAO.MapDao;
import com.alexd.model.CargoEntity;
import com.alexd.model.MapEntity;
import com.alexd.service.DriverService;
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

byte a = 1;
        TruckService t = new TruckService();

        t.addTruck("888aw", 20,100,false);
       ArrayList<TruckView> arr=  t.selectAll();

for(int i=0;i<arr.size();i++)
{
    System.out.print(arr.get(i).getId()+" "+arr.get(i).getSize()+" "+arr.get(i).getCity());
    System.out.println();
}


System.exit(0);

    }




}
