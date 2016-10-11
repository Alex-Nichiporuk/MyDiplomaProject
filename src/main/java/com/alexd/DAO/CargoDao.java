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

    public int addCargo(String name, double weight, int status)
    {
        setEntity(name, weight, status);
            this.insert(e);
             return e.getId();
    }


    public void deleteCargo(String name, double weight, int status)
    {
        setEntity(name, weight, status);
        this.delete(e);

    }

    public void updateCargo(String name, double weight, int status)
    {
        setEntity(name, weight, status);
        this.update(e);

    }

    public int findMaxId() {
        return 0;
    }

    public Object findByMaxId() {
        return null;
    }
}