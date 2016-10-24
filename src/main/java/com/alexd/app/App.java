package com.alexd.app;




import com.alexd.DAO.PathDao;
import com.alexd.service.*;
import com.alexd.util.man.GooglePathFind;
import com.alexd.util.man.TimeUtil;
import com.alexd.view.util.DriverUIView;
import com.alexd.view.util.DriverView;
import com.alexd.view.util.TruckView;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.jar.Pack200;

public class App
{


    public static void main( String[] args ) throws IOException {

    OrderService o = new OrderService();
        DriverService driverService = new DriverService();
      int pathId =  o.addPath();
      int pointOne =  o.addPoint(118, pathId);
     int pointTwo =   o.addPoint(111, pathId);
      int cargoId =  o.addCargo("Meat", 9f, 0);
        o.bindCargoPoint(cargoId, pointOne, false,new Timestamp(1000000l));
        o.bindCargoPoint(cargoId, pointTwo, true,new Timestamp(1000000l));
         ArrayList<String> check = o.checkCargoPath(pathId);
        ArrayList<TruckView> truckViews =   o.checkTruck(pathId);
      String t =  truckViews.get(0).getId();
    int timeId=   o.addTimePlan(TimeUtil.convertStringToTimestamp("27/06/2016").getTime(),TimeUtil.convertStringToTimestamp("3/07/2016").getTime());
      ArrayList<DriverView>driverViews=  driverService.portableDriver(timeId,t);
      int driverDesc=   o.bindDriver(driverViews.get(0).getId(), pathId);
        if(driverViews.size()>1) {
            o.bindDriver(driverViews.get(1).getId(), driverDesc);
        }
   int idO = o.addOrder(pathId,timeId,t,driverDesc);
        o.pathUp(idO);
        driverService.updateTimeDriver(idO);
        o.truckUp(t);

System.exit(0);

    }




}
