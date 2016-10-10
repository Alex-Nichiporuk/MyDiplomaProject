package com.alexd.app;



//import com.alexd.DAO.MapDao;


import com.alexd.DAO.CargoDao;
import com.alexd.DAO.DriverDao;
import com.alexd.DAO.MapDao;
import com.alexd.model.MapEntity;

public class App
{


    public static void main( String[] args )
    {


        CargoDao c = new CargoDao();
       int id = c.addCargo("порошок", 15,0);


        System.out.print(id);

System.exit(0);

    }




}
