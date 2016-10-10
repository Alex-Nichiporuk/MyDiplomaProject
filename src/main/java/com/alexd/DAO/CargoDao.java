package com.alexd.DAO;

import com.alexd.model.CargoEntity;

/**
 * Created by Cj444 on 10.10.2016.
 */
public class CargoDao extends GenericClass {

    public CargoDao() {
        super( CargoEntity.class);
    }


    public int addCargo(String name, double weight, int status)
    {
        CargoEntity e = new CargoEntity();

        try{

            e.setName(name);
            e.setWeight(weight);
            e.setStatus(status);
            this.beginTransaction();
            this.insert(e);
            this.commitTransaction();
        }
        catch (Exception exc)
        {
            return -1;
        }
        return e.getId();


    }


    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}