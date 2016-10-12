package com.alexd.service;

import com.alexd.DAO.*;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.CheckCargoView;


import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Cj444 on 12.10.2016.
 */
public class OrderService {
    EntityManager em;
    OrdersDao ordersDao;
    PathDao pathDao;
    PointDao pointDao;
    CargoDao cargoDao;
    PointHasCargoDao pointHasCargoDao;

    public OrderService()
    {
        em = EntManager.getManager();

        ordersDao = new OrdersDao();
        pathDao = new PathDao();
          pointDao = new PointDao();
        cargoDao = new CargoDao();
        pointHasCargoDao = new PointHasCargoDao();

    }

public int addOrder()
{

return -1;

}

public int addPath()
{
    int id;
    try {
    em.getTransaction().begin();
  id =  pathDao.addPath(0);
}
catch (Exception exc)
{
    return -1;
}
    return id;
}

public int addPoint(int map_id, int path_id)
{
    int id;
    try{
        em.getTransaction().begin();
       id = pointDao.addPoint(map_id,path_id);
    }
    catch (Exception exc)
    {
        return -1;

    }

    return id;
}


public int addCargo(String name, double weight, int status)
{
    int id;
    try
    {
        em.getTransaction().begin();
        id = cargoDao.addCargo(name,weight,status);
    }
    catch (Exception exc)
    {
        return -1;
    }

return id;
}


public int bindCargoPoint(int cargo_id, int point_id, byte status, Timestamp date)
{
    int id;
    try
    {
        em.getTransaction().begin();
        id = pointHasCargoDao.addPointHasCargo(cargo_id,point_id, status, date);
    }
    catch (Exception exc)
    {
        return -1;
    }
    return id;

}

public ArrayList<String> checkCargoPath(int path_id)
{
   ArrayList<CheckCargoView>chk= ordersDao.checkCargo(em,path_id);
    ArrayList<String> errors = new ArrayList<String>();
    boolean flag = true;
    int count=0;




for(CheckCargoView a:chk)
{
    for(CheckCargoView b:chk)
    {

        if(a.getCargo_id()==b.getCargo_id())
        {
            if(a.isStatus()==b.isStatus())
            {
                errors.add("Груз: "+a.getCargo_id()+" неправильно погружен/отгружен");
                flag = false;
            }
            else if(a.getPoint_id()>  b.getPoint_id())
            {
                if(a.isStatus()==false)
                {
                    errors.add("Груз: "+a.getCargo_id()+" нельзя выгрузить раньше чем загрузить");
                    flag = false;
                }
                else
                {
                    chk.remove(a);
                    chk.remove(b);
                }
            }
        }

    }
}

if(chk.size()>0)
{
    for(CheckCargoView a:chk)
    {
        errors.add("Груз: "+a.getCargo_id()+"нигде не загружен или нигде не отгружен");
    }
}
return errors;
}




}
