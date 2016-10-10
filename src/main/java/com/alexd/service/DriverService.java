package com.alexd.service;

import com.alexd.DAO.DriverDao;
import com.alexd.model.DriverEntity;
//import com.alexd.DAO.MapDao;

import java.sql.Timestamp;

/**
 * Created by Cj444 on 09.10.2016.
 */
public class DriverService {


     boolean addDriver( String name, String lastName, String city)
    {
        try {
            DriverDao driverDao = new DriverDao();
            DriverEntity driverEntity = new DriverEntity();
     //       MapDao mapDao = new MapDao();

            driverEntity.setName(name);
            driverEntity.setLastName(lastName);
            driverEntity.setStatus(0);
            driverEntity.setTimeStatus(new Timestamp(1970 - 01 - 01 - 03 - 00 - 00));
            driverDao.beginTransaction();
            driverDao.insert(driverEntity);
            driverDao.commitTransaction();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }





}