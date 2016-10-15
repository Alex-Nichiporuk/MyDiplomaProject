package com.alexd.app;




import com.alexd.service.DriverUI;
import com.alexd.view.util.DriverUIView;

public class App
{


    public static void main( String[] args )
    {

        DriverUI driverUI = new DriverUI();
       DriverUIView a = driverUI.getInfo(7);



System.exit(0);

    }




}
