package com.alexd.app;



import com.alexd.DAO.Drivers;
import com.alexd.DAO.DriversDao;
import com.alexd.DAO.GenericClass;
import com.alexd.DAO.GenericDao;
import com.alexd.model.DriversEntity;


public class App 
{


    public static void main( String[] args )
    {
        GenericDao a = new GenericClass();
        a.setEm();
        a.beginTransaction();
        DriversEntity  b = (DriversEntity)a.findById(204);
        System.out.print("Name: "+b.getName()+" Last name: "+b.getLastName());
        a.closeEm();

    }
}
