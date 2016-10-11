package com.alexd.service;

import com.alexd.DAO.OrdersDao;
import com.alexd.DAO.PathDao;
import com.alexd.DAO.PointDao;
import com.alexd.util.man.EntManager;


import javax.persistence.EntityManager;

/**
 * Created by Cj444 on 12.10.2016.
 */
public class OrderService {
    EntityManager em;
    OrdersDao ordersDao;
    PathDao pathDao;
    PointDao pointDao;

    public OrderService()
    {
        em = EntManager.getManager();
        ordersDao = new OrdersDao();
        pathDao = new PathDao();
          pointDao = new PointDao();
    }

public int addOrder()
{

return -1;

}

public int addPath()
{

    return pathDao.addPath(0);
}

public int addPoint(int map_id, int path_id)
{
    return pointDao.addPoint(map_id,path_id);
}




}
