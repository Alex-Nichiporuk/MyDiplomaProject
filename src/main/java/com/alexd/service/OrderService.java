package com.alexd.service;

import com.alexd.DAO.*;
import com.alexd.model.*;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Time;
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


    public ArrayList<OrderView> getAll()
    {
        ArrayList<OrderView> orderViews = new ArrayList<OrderView>();
        for(OrdersEntity o : ordersDao.getAll())
        {
            orderViews.add(new OrderView(o));
        }
return orderViews;
    }



public int addOrder(int pathId, int timeId, String truckId, int driverDescId )
{
    OrdersEntity  ordersEntity = new OrdersEntity(false, pathId,timeId,truckId,driverDescId);
ordersDao.insert(ordersEntity);
return ordersEntity.getId();

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


public int addTimePlan(long begin, long end)
{
    TimeDao timeDao = new TimeDao();
    TimeEntity timeEntity = new TimeEntity(new Timestamp(begin), new Timestamp(end));
    timeDao.insert(timeEntity);
    return timeEntity.getId();
}




public int bindDriver(int driverId , int driverDesc) {
    GenericClass<DriversdescEntity> genericClass = new GenericClass<DriversdescEntity>();
    DriversdescEntity driversdescEntity = new DriversdescEntity(driverId, 0l,driverDesc);
    genericClass.insert(driversdescEntity);
    return driversdescEntity.getDescId();
}


public void pathUp(int id)
{
    pathDao.pathLength(id);
}

public void truckUp(String id)
{
    truckDao.setBusyTruck(id);
}




public String htmlPoints(String city)
{
    if(city.equals(""))
    {
        city = " City name";
    }
    String html = "<form method=\"post\" class=\"login-container\"  action=\"EditServlet\">\n" +
        "                        <div class=\"form-group\">\n" +
        "                            <label for=\"email\" class=\"cols-sm-2 control-label\">City name</label>\n" +
        "                            <div class=\"cols-sm-10\">\n" +
        "                                <div class=\"input-group\">\n" +
        "                                    <span class=\"input-group-addon\"><i class=\"fa fa-user fa\" aria-hidden=\"true\"></i></span>\n" +
        "                                    <input type=\"text\" class=\"form-control\" name=\"cityName\" id=\"cityName\"  value=\""+city+"\"/>\n" +
        "                                </div>\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "\n" +

        "\n" +
        "   <input type=\"submit\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"SAVE PATH\" style=\" margin: auto; ; float: left; font-size: 20px; width: 20% \"> </input>\n" +
            "    <input type=\"button\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"ADD CARGO\" onclick=\"f(\'cargo\')\" style=\" margin: 0% 0% 0% 80%;  font-size: 20px; width: 20% \"> </input> \n" +
        "    <input type=\"button\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"NEXT POINT\" onclick=\"f()\" style=\" margin: 0% 0% 0% 80%;  font-size: 20px; width: 20% \"> </input> \n" +

        "\n" +
        "\n" +
        "\n" +
        "</form>";
    return html;
}


public  String htmlCargo() {
    String html = "<form method=\"post\" class=\"login-container\"  action=\"AddOrderServlet\">\n" +
            "                        <div class=\"form-group\">\n" +
            "                            <label for=\"cargoname\" class=\"cols-sm-2 control-label\">Cargo name</label>\n" +
            "                            <div class=\"cols-sm-10\">\n" +
            "                                <div class=\"input-group\">\n" +
            "                                    <span class=\"input-group-addon\"><i class=\"fa fa-users fa\" aria-hidden=\"true\"></i></span>\n" +
            "                                    <input type=\"text\" class=\"form-control\" name=\"cargoname\" id=\"cargoname\"  value=\"\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\n" +
            "                        <div class=\"form-group\">\n" +
            "                            <label for=\"cargoweight\" class=\"cols-sm-2 control-label\">Cargo weight</label>\n" +
            "                            <div class=\"cols-sm-10\">\n" +
            "                                <div class=\"input-group\">\n" +
            "                                    <span class=\"input-group-addon\"><i class=\"fa fa-building-o fa-lg\" aria-hidden=\"true\"></i></span>\n" +
            "                                    <input type=\"text\" class=\"form-control\" name=\"cargoweight\" id=\"cargoweight\"  value=\"\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\n" +
            "                        <div class=\"form-group\">\n" +
            "                            <label for=\"cargostatus\" class=\"cols-sm-2 control-label\">Status</label>\n" +
            "                            <div class=\"cols-sm-10\">\n" +
            "                                <div class=\"input-group\">\n" +
            "                                    <span class=\"input-group-addon\"><i class=\"fa fa-building-o fa-lg\" aria-hidden=\"true\"></i></span>\n" +
            "                                    <input type=\"text\" class=\"form-control\" name=\"cargostatus\" id=\"cargostatus\"  value=\"\"/>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "\n" +
            "\n" +
            "   <input type=\"submit\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"SAVE CARGO\" onclick=\"f(\'point\')\"  style=\" margin: auto; ; float: left; font-size: 20px; width: 20% \"> </input>\n" +

            "    <input type=\"button\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"NEXT CARGO\" onclick=\"f(\'cargo\')\" style=\" margin: 0% 0% 0% 80%;  font-size: 20px; width: 20% \"> </input> \n" +

            "\n" +
            "\n" +
            "\n" +
            "</form>";
return html;
}


public int addCargo(String name, String weight)
{
    CargoEntity cargoEntity = new CargoEntity(name,Float.parseFloat(weight),0);
    GenericClass<CargoEntity> genericClass = new GenericClass<CargoEntity>();
    genericClass.insert(cargoEntity);
    return cargoEntity.getId();
}



}



