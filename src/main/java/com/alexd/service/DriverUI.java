package com.alexd.service;

import com.alexd.DAO.DriverDao;
import com.alexd.DAO.PathDao;
import com.alexd.model.DriverEntity;
import com.alexd.model.OrdersEntity;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.DriverUIView;
import com.alexd.view.util.PointView;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Cj444 on 14.10.2016.
 */
public class DriverUI {

    DriverDao driverDao = new DriverDao();
     PathDao pathDao = new PathDao();

    public DriverUIView getInfo(Integer id)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        DriverEntity driverEntity = (DriverEntity)driverDao.findById(id);
       OrdersEntity ordersEntity = driverDao.getOrder(driverEntity.getId());
        ArrayList<PointView>pointViews = pathDao.pointAndCargo(ordersEntity.getId(),em);
        HashMap<Integer , String> coDriver = driverDao.getCodriver(ordersEntity.getId(),em);
        DriverUIView info = new DriverUIView(driverEntity,ordersEntity,pointViews,coDriver);
        return info;

    }



}
