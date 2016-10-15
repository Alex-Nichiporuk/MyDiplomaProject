package com.alexd.service;

import com.alexd.DAO.*;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.CargoWeightView;
import com.alexd.view.util.CheckCargoView;
import com.alexd.view.util.TruckView;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.util.*;

public class OrderService {

    OrdersDao ordersDao;
    PathDao pathDao;
    PointDao pointDao;
    CargoDao cargoDao;
    TruckDao truckDao;
    EntityTransaction pathTransaction;
    EntityManager pathEm;
    public OrderService()
    {


        ordersDao = new OrdersDao();
        pathDao = new PathDao();
          pointDao = new PointDao();
        cargoDao = new CargoDao();
        truckDao = new TruckDao();

    }

public int addOrder()
{

return -1;

}

public int addPath()
{
     pathEm = EntManager.getManager().createEntityManager();
    PathEntity pathEntity = new PathEntity();

    try {
        pathTransaction =   pathEm.getTransaction();
        pathTransaction.begin();
  pathDao.insert(pathEntity);
}
catch (Exception exc)
{
    return -1;
}
    return pathEntity.getId();
}

public int addPoint(int mapId, int pathId)
{
    PointEntity pointEntity = new PointEntity(mapId, pathId);
    try{
         pointDao.insert(pointEntity);
    }
    catch (Exception exc)
    {
        return -1;

    }

    return pointEntity.getId();
}


public boolean endTransactionPath(boolean end)
{
    try{
        if(end==true) {
            pathTransaction.commit();
        }
        else
        {
            pathTransaction.rollback();
        }
    }
    catch (Exception exc)
    {
        return false;
    }
    return true;
}



public int addCargo(String name, float weight, int status)
{
    GenericService<CargoEntity> genericService = new GenericService<CargoEntity>();
    CargoEntity cargoEntity = new CargoEntity(name,weight,status);
   genericService.add(cargoEntity);
return cargoEntity.getId();
}


public boolean bindCargoPoint(int cargo_id, int point_id, boolean status, Timestamp date)
{
    GenericService<PointHasCargoEntity> genericService = new GenericService<PointHasCargoEntity>();
    PointHasCargoEntity pointHasCargoEntity = new PointHasCargoEntity(cargo_id,point_id, status, date);
    return genericService.add(pointHasCargoEntity);

}

public ArrayList<String> checkCargoPath(int pathId)
{
    EntityManager em = EntManager.getManager().createEntityManager();
   ArrayList<CheckCargoView>chk= pathDao.checkCargo(em,pathId);
    ArrayList<String> errors = new ArrayList<String>();


for(CheckCargoView a:chk)
{
    for(CheckCargoView b:chk)
    {

        if(a.equals(b)==false && a.getCargo_id()==b.getCargo_id()&& a.getCheck()!=1)
        {
            if(a.isStatus()==b.isStatus())
            {
                errors.add("Груз: "+a.getCargo_id()+" неправильно погружен/отгружен");

            }
            else if(a.getPoint_id()>  b.getPoint_id())
            {
                if(a.isStatus()==false)
                {
                    errors.add("Груз: "+a.getCargo_id()+" нельзя выгрузить раньше чем загрузить");

                }

            }
            else if(a.getPoint_id()<  b.getPoint_id())
            {
                if(a.isStatus()==true)
                {
                    errors.add("Груз: "+a.getCargo_id()+" нельзя выгрузить раньше чем загрузить");

                }

            }
            a.setCheck(1);
            b.setCheck(1);
        }

    }

}

    for(CheckCargoView a:chk)
    {
    if(a.getCheck()==0) {
        errors.add("Груз: " + a.getCargo_id() + " нигде не загружен или нигде не отгружен");
    }
}
return errors;
}


public ArrayList<TruckView> checkTruck(int pathId)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    ArrayList<CargoWeightView>cargoWeightViews = pathDao.checkWeight(em,pathId);
    ArrayList<TruckView> result;

    float max = 0F;
    float truck = 0F;
    for(CargoWeightView a : cargoWeightViews)
    {
        if(a.isStatus())
        {
            truck=truck-a.getWeight();
        }
        else
        {
            truck=truck+a.getWeight();
            if(truck>max)
            {
                max=truck;
            }
        }
    }

    result = truckDao.selectCheckedTrucks(em,max);



return result;
}


}
