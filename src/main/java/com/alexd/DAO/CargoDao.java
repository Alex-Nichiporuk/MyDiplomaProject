package com.alexd.DAO;

import com.alexd.model.CargoEntity;

/**
 * Created by Cj444 on 10.10.2016.
 */
public class CargoDao extends GenericClass {

    CargoEntity e;

    public CargoDao() {
        super( CargoEntity.class);
    }

    private void setEntity(String name, double weight, int status)
    {
        e = new CargoEntity();
        e.setName(name);
        e.setWeight(weight);
        e.setStatus(status);
    }

    private void setEntity(int id, String name, double weight, int status)
    {
        e = new CargoEntity();
        e.setName(name);
        e.setWeight(weight);
        e.setStatus(status);
        e.setId(id);
    }




    public int addCargo(String name, double weight, int status)
    {
        setEntity(name, weight, status);
            this.insert(e);
             return e.getId();
    }



    public void updateCargo(int id , String name, double weight, int status)
    {
        setEntity(  id ,   name,   weight,   status);
        this.update(e);

    }


}