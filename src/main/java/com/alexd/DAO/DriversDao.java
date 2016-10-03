package com.alexd.DAO;

import com.alexd.model.DriversEntity;



/**
 * Created by Cj444 on 03.10.2016.
 */
public interface DriversDao {
    public void persist(DriversEntity entity);
    public void update(DriversEntity entity);
    public DriversEntity findById(int id);
    public void delete(DriversEntity entity);
    public void setEm();
    public void beginTransaction();
    public void closeEm();
    public void commitTransaction();
}
