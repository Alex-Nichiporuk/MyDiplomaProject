package com.alexd.service;

import com.alexd.DAO.MapDao;
import com.alexd.model.MapEntity;
import com.alexd.util.man.EntManager;
import com.alexd.util.man.GooglePathFind;

import javax.persistence.EntityManager;
import java.io.IOException;

/**
 * Created by Cj444 on 16.10.2016.
 */
public class MapService {
    MapDao mapDao = new MapDao();
    public boolean addCity(String name)
    {
        EntityManager em = EntManager.getManager().createEntityManager();
        double [] coor = null;
        try {

            coor = GooglePathFind.getCoor(name);
            MapEntity mapEntity = new MapEntity(name,coor[0],coor[1]);
            em.getTransaction().begin();
            mapDao.insert(mapEntity);
            em.getTransaction().commit();
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }

        return true;

    }
}
