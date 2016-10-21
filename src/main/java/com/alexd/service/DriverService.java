package com.alexd.service;

import com.alexd.DAO.*;
import com.alexd.model.DriverEntity;
import com.alexd.model.OrdersEntity;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.DriverView;
import org.osgi.service.device.Driver;


import javax.persistence.EntityManager;
import java.sql.Timestamp;

import java.util.*;
import java.util.List;

/**
 * Created by Cj444 on 09.10.2016.
 */
public class DriverService implements DriverServiceImpl {
EntityManager em;
    DriverDao driverDao;
    OrdersDao orderDao;
    TimeDao timeDao;

    public DriverService()
    {
        driverDao = new DriverDao();
        orderDao = new OrdersDao();
        timeDao = new TimeDao();

    }

    public boolean delDriver(String id)
    {
        try
        {
            UserDao userDao = new UserDao();
            userDao.deleteDriver(Integer.parseInt(id));
            driverDao.delete(Integer.parseInt(id));

            return true;
        }
        catch (Exception e)
        {
            return false;

        }

    }

    public int addDriver(String name, String lastname, int city)
    {
        GenericService<DriverEntity> genericService = new GenericService<DriverEntity>();
       DriverEntity de = new DriverEntity(name,lastname,city);
    genericService.add(de);
      return  de.getId();
    }

    public boolean updateDriver(int id, String name, String lastname, int city)
    {
        try {
            em.getTransaction().begin();
            driverDao.update(new DriverEntity(id,name,lastname,city));
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

public   ArrayList<DriverView> selectAll()
{

        List<DriverEntity> resultQuery = new DriverDao().selectAll();
    ArrayList<DriverView> b = new ArrayList<DriverView>();
    DriverDao driverDao = new DriverDao();
    for(DriverEntity a : resultQuery)
    {
        if(driverDao.getOrder(a.getId())!=null) {
            b.add(new DriverView(a, driverDao.getOrder(a.getId()).getId()));
        }
        else
        {
            b.add(new DriverView(a, 0));
        }
    }



        return b;



}


public DriverView getById(int id)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    DriverEntity driverEntity = (DriverEntity)  driverDao.findById(id);
    DriverView driverView = new DriverView(driverEntity);
    return driverView;
}


public ArrayList<DriverView> getDriversBydifferent(String code)
{
    DriverDao driverDao = new DriverDao();
    try{
        int id = Integer.parseInt(code);
        ArrayList<DriverView> result = new ArrayList<DriverView>();
                result.add(new DriverView((DriverEntity) driverDao.findById(id)));

        return result;
    }
    catch (Exception exc)
    {
        List<DriverEntity> driverEntities = driverDao.getByDif(code);
        ArrayList<DriverView> result = new ArrayList<DriverView>();
        for(DriverEntity a : driverEntities)
        {
            if(driverDao.getOrder(a.getId())!=null) {
                result.add(new DriverView(a, driverDao.getOrder(a.getId()).getId()));
            }
            else
            {
                result.add(new DriverView(a, 0));
            }
        }
return result;
    }

}






public boolean changeTime(int id , long time)
{
    try {
        DriverEntity driverEntity = (DriverEntity) driverDao.findById(id);
        driverEntity.setTimeStatus(driverEntity.getTimeStatus() + time);
        driverDao.update(driverEntity);
        return true;
    }
    catch (Exception exc)
    {
        return false;
    }
}


public ArrayList<DriverView> portableDriver(int time , String truck)
{
    EntityManager em = EntManager.getManager().createEntityManager();
    List<DriverEntity> result = driverDao.getDriverForOrder(checkTimeForDriver(time),truck, em);
    ArrayList<DriverView> driverViews = new ArrayList<DriverView>();
    for(DriverEntity a : result)
    {
        driverViews.add(new DriverView(a));
    }

return  driverViews;
}


public String htmlTable(String code)
{
    ArrayList<DriverView> driverViews  =   getDriversBydifferent(code);

    String htmlHead = "<table  id=\"table1\" class=\"table table-striped\" style=\"width: 100%\">\n" +
            "         <thead>\n" +
            "         <tr >\n" +
            "             <td>Number</td>\n" +
            "             <td style=\"width: 204px\">Name</td>\n" +
            "             <td style=\"width: 204px\">Last name</td>\n" +
            "             <td>Truck number</td>\n" +
            "             <td style=\"width: 204px\">Current city</td>\n" +
            "             <td>Status</td>\n" +
            "             <td>Work time</td>\n" +
            "             <td>Current order</td>\n" +
            "\n" +
            "         </tr>\n" +
            "         </thead>\n" +
            "\n";
    String data="";

    for(DriverView a : driverViews) {
          data = data +


                "             <tr onclick=\"choiceOf(this)\">\n" +
                "                 <td>" + a.getId() + "</td>"+
                "                 <td>" + a.getName() + "</td>"+
                "                 <td>" + a.getLastname() + "</td>"+
                "                 <td>" + a.getTruck() + "</td>"+
                "                 <td>" + a.getCity() + "</td>"+
                "                 <td>" + a.getStatus() + "</td>"+
                "                 <td>" + a.getTime() + "</td>"+
                "                 <td>" + a.getOrder() + "</td>"+
                "             </tr>\n" ;

    }
   String htmlEnd =  "     </table>";
return htmlHead+data+htmlEnd;
}








public long checkTimeForDriver(int time)
{

    long workPeriod;
    if( compareMonth(timeDao.getEndTime(time) , timeDao.getBeginTime(time)))
    {
        workPeriod = timeDao.getEndTime(time) -timeDao.getBeginTime(time);
    }
    else
    {
        Calendar b = Calendar.getInstance();
        b.setTime(new Date(timeDao.getEndTime(time)));

workPeriod = notFullMonth( timeDao.getBeginTime(time), timeDao.getEndTime(time));

    }


return workPeriod;
}

private boolean compareMonth(long begin, long end)
{
    Calendar a = Calendar.getInstance();
    Calendar b = Calendar.getInstance();
    a.setTime(new Date(begin));
    b.setTime(new Date(end));

    return !((a.get(Calendar.MONTH) > b.get(Calendar.MONTH)) || (a.get(Calendar.MONTH) < b.get(Calendar.MONTH) && a.get(Calendar.YEAR) > b.get(Calendar.YEAR)));
}


private long notFullMonth(long begin, long end)
{

    Calendar b = Calendar.getInstance();
    b.setTime(new Date(end));

    return end - begin - b.get(Calendar.DAY_OF_MONTH)*3600000*24-b.get(Calendar.HOUR_OF_DAY)*3600000 ;


}


}