package com.alexd.app;




import com.alexd.DAO.PathDao;
import com.alexd.service.DriverService;
import com.alexd.service.DriverUI;
import com.alexd.service.MapService;
import com.alexd.service.UserService;
import com.alexd.util.man.GooglePathFind;
import com.alexd.view.util.DriverUIView;
import com.alexd.view.util.DriverView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Pack200;

public class App
{


    public static void main( String[] args ) throws IOException {

        DriverService driverService = new DriverService();
        MapService mapService = new MapService();

      driverService.addDriver("Владимир", "Ульянов", mapService.checkCity("Череповец"));
System.exit(0);

    }




}
