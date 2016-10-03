package com.alexd.DAO;

import com.alexd.model.DriversdescEntity;

/**
 * Created by Cj444 on 03.10.2016.
 */
public interface DriverDescDao {
    public void persist(DriversdescEntity entity);
    public void update(DriversdescEntity entity);
    public DriversdescEntity findById(int id);
    public void delete(DriversdescEntity entity);
    public void setEm();
    public void beginTransaction();
    public void closeEm();
    public void commitTransaction();
}
