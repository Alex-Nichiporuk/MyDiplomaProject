package com.alexd.service;

import com.alexd.DAO.*;
import com.alexd.model.DriverEntity;
import com.alexd.model.OrdersEntity;
import com.alexd.util.man.EntManager;
import com.alexd.view.util.DriverView;


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

private List<DriverEntity> selectAlldao()
{
    try {
        em.getTransaction().begin();
        List<DriverEntity> resultQuery = driverDao.selectAll(em);
        em.getTransaction().commit();

        return resultQuery;
    }
    catch (Exception e)
    {
        return null;
    }


}


public List<DriverView> selectAll()
{
    List<DriverEntity> driverEntities =  selectAlldao();
    List<DriverView>driverViews = new ArrayList<DriverView>();
    for(int i = 0; i<driverEntities.size();i++)
    {
        driverViews.add(new DriverView(driverEntities.get(i)));
    }
    return driverViews;
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

    if((a.get(Calendar.MONTH)>b.get(Calendar.MONTH))||(a.get(Calendar.MONTH)<b.get(Calendar.MONTH)&&a.get(Calendar.YEAR)>b.get(Calendar.YEAR)))
    {
        return false;
    }
    else
    {
        return true;
    }
}


private long notFullMonth(long begin, long end)
{

    Calendar b = Calendar.getInstance();
    b.setTime(new Date(end));

    return end - begin - b.get(Calendar.DAY_OF_MONTH)*3600000*24-b.get(Calendar.HOUR_OF_DAY)*3600000 ;


}


}