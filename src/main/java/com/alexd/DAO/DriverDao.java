package com.alexd.DAO;


import com.alexd.model.DriverEntity;
import com.alexd.util.man.EntManager;

import javax.persistence.Query;

/**
 * Created by Cj444 on 08.10.2016.
 */
public class DriverDao  extends GenericClass {


        public DriverDao() {
            super(DriverEntity.class);
        }


    public boolean addDriver(String name, String lastname, int city)
    {
        try{

            DriverEntity e = new DriverEntity();
            e.setName(name);
            e.setLastName(lastname);
            e.setStatus(0);
            e.setMapId(city);
            this.beginTransaction();
            this.insert(e);
            this.commitTransaction();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;


    }
















        public Object findByMaxId() {

            String maxIdquery = "SELECT * FROM  truck_app.drivers;";
            Query maxId = EntManager.getManager().createNativeQuery(maxIdquery);
     /*   DriversEntity*/ Object  result = /*(DriversEntity)*/ maxId.getSingleResult();
            Object[]a= (Object[])result;
            int b =(Integer)a[0];
            return result;
        }

            public int findMaxId() {
            return 0;
        }


}
