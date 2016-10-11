package com.alexd.DAO;


import com.alexd.model.DriverEntity;
import com.alexd.util.man.EntManager;

import javax.persistence.Query;

/**
 * Created by Cj444 on 08.10.2016.
 */
public class DriverDao  extends GenericClass {
    DriverEntity e;

        public DriverDao() {
            super(DriverEntity.class);
        }





    private void setEntity(String name, String lastname, int city)
    {
         e = new DriverEntity();
        e.setName(name);
        e.setLastName(lastname);
        e.setStatus(0);
        e.setMapId(city);
    }

    public int addDriver(String name, String lastname, int city)
    {
        setEntity( name,  lastname,  city);
        this.insert(e);
        return e.getId();
    }


    public void deleteDriver(String name, String lastname, int city)
    {
        setEntity( name,  lastname,  city);
        this.delete(e);

    }

    public void updateDriver(String name, String lastname, int city)
    {
        setEntity( name,  lastname,  city);
        this.update(e);

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
