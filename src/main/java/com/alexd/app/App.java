package com.alexd.app;




import com.alexd.service.DriverService;
import com.alexd.service.DriverUI;
import com.alexd.view.util.DriverUIView;
import com.alexd.view.util.DriverView;

import java.util.ArrayList;

public class App
{


    public static void main( String[] args )
    {

        DriverService driverService = new DriverService();
       ArrayList<DriverView> a = driverService.portableDriver(2,"777aa");


System.exit(0);

    }




}
