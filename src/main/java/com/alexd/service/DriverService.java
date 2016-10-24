package com.alexd.service;

import com.alexd.DAO.*;
import com.alexd.model.*;
import com.alexd.util.man.EntManager;
import com.alexd.util.man.TimeUtil;
import com.alexd.view.util.DriverStatView;
import com.alexd.view.util.DriverView;
import com.alexd.view.util.UserView;
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
    UserDao userDao;

    public DriverService()
    {
        driverDao = new DriverDao();
        orderDao = new OrdersDao();
        timeDao = new TimeDao();
        userDao = new UserDao();

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

    public boolean updateDriver(int id, String name, String lastname, int city, String login, String password, int userId)
    {
       try {
           driverDao.update(new DriverEntity(id, name, lastname, city));
           userDao.update(new UserEntity(userId, login, password, name, lastname, 3, id));
       }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }


    public UserView getDriverByDriverId(String id)
    {
        UserDao userDao = new UserDao();

        return new UserView(userDao.getByDriverId(Integer.parseInt(id)));
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
 TimeEntity timeEntity = (TimeEntity)timeDao.findById(time);
long summ=0;
    long summ2 = 0;
    ArrayList<DriverView> driverViews = new ArrayList<DriverView>();
    if(TimeUtil.getMonth(timeEntity.getBegin())==TimeUtil.getMonth(timeEntity.getEnd())) {
     long   workPeriod = timeDao.getEndTime(time) -timeDao.getBeginTime(time);
        for (DriverEntity a : result) {
            for (DriversplanEntity b : a.getDriversplenById()) {
                if (TimeUtil.getMonth(b.getDriverDate())==TimeUtil.getMonth(timeEntity.getBegin()))
                {
                    summ=summ+b.getWorkTime();
                }

            }
if(summ+workPeriod<633600000)
{
    driverViews.add(new DriverView(a));
}
        }
    }
    else
    {
        long   fullPeriod = timeDao.getEndTime(time) -timeDao.getBeginTime(time);
    long    workPeriod1 = notFullMonth( timeDao.getBeginTime(time), timeDao.getEndTime(time));
        long   workPeriod2 = fullPeriod-workPeriod1;

        for (DriverEntity a : result) {
            for (DriversplanEntity b : a.getDriversplenById()) {
                if (TimeUtil.getMonth(b.getDriverDate())==TimeUtil.getMonth(timeEntity.getBegin()))
                {
                    summ=summ+b.getWorkTime();
                }
                if(TimeUtil.getMonth(b.getDriverDate())==TimeUtil.getMonth(timeEntity.getEnd()))
                {
                    summ2=summ2+b.getWorkTime();
                }

            }
            if(summ+workPeriod1<633600000&&summ2+workPeriod2<633600000)
            {
                driverViews.add(new DriverView(a));
            }
        }



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

    public String editHtmlDriver(String id)
    {
        UserDao userDao = new UserDao();
        DriverView driverView  =  new DriverView((DriverEntity) driverDao.findById(Integer.parseInt(id)));
        UserEntity userEntity = userDao.getByDriverId(Integer.parseInt(id));
        String html = "<form method=\"post\" class=\"login-container\"  action=\"EditServlet\">\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label for=\"email\" class=\"cols-sm-2 control-label\">Driver name</label>\n" +
                "                            <div class=\"cols-sm-10\">\n" +
                "                                <div class=\"input-group\">\n" +
                "                                    <span class=\"input-group-addon\"><i class=\"fa fa-user fa\" aria-hidden=\"true\"></i></span>\n" +
                "                                    <input type=\"text\" class=\"form-control\" name=\"name\" id=\"email\"  value=\""+driverView.getName()+"\"/>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label for=\"username\" class=\"cols-sm-2 control-label\">Driver last name</label>\n" +
                "                            <div class=\"cols-sm-10\">\n" +
                "                                <div class=\"input-group\">\n" +
                "                                    <span class=\"input-group-addon\"><i class=\"fa fa-users fa\" aria-hidden=\"true\"></i></span>\n" +
                "                                    <input type=\"text\" class=\"form-control\" name=\"lastname\" id=\"username\"  value=\""+driverView.getLastname()+"\"/>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label for=\"password\" class=\"cols-sm-2 control-label\">City</label>\n" +
                "                            <div class=\"cols-sm-10\">\n" +
                "                                <div class=\"input-group\">\n" +
                "                                    <span class=\"input-group-addon\"><i class=\"fa fa-building-o fa-lg\" aria-hidden=\"true\"></i></span>\n" +
                "                                    <input type=\"text\" class=\"form-control\" name=\"city\" id=\"password\"  value=\""+driverView.getCity()+"\"/>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <label for=\"confirm\" class=\"cols-sm-2 control-label\">Driver login</label>\n" +
                "                            <div class=\"cols-sm-10\">\n" +
                "                                <div class=\"input-group\">\n" +
                "                                    <span class=\"input-group-addon\"><i class=\"fa fa-bell fa-lg\" aria-hidden=\"true\"></i></span>\n" +
                "                                    <input type=\"text\" class=\"form-control\" name=\"login\" id=\"confirm\"  value=\""+userEntity.getLogin()+"\"/>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"confirm\" class=\"cols-sm-2 control-label\">Password</label>\n" +
                "                    <div class=\"cols-sm-10\">\n" +
                "                        <div class=\"input-group\">\n" +
                "                            <span class=\"input-group-addon\"><i class=\"fa fa-lock fa-lg\" aria-hidden=\"true\"></i></span>\n" +
                "                            <input type=\"password\" class=\"form-control\" name=\"password\"    placeholder=\"password\"/>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "<span style=\"color: red\">\n" +
                "     <c:if test=\"${not empty error}\">\n" +
                "        <c:out value=\"${error}\"> </c:out>\n" +
                "    </c:if>\n" +
                "</span>\n" +
                "    <span style=\"color: green\">\n" +
                "<c:if test=\"${not empty driver}\">\n" +
                "    <c:out value=\"${driver}\"> </c:out>\n" +
                "</c:if>\n" +
                "\n" +
                "</span>\n" +
                "\n" +
                "   <input type=\"submit\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"OK\" style=\" margin: auto; ; float: left; font-size: 20px; width: 20% \"> </input>\n" +
                "    <input type=\"button\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"Cancel\" onclick=\"f()\" style=\" margin: 0% 0% 0% 80%;  font-size: 20px; width: 20% \"> </input> \n" +

                "\n" +
                "\n" +
                "\n" +
                "</form>";
return html;
    }


    public void updateTimeDriver(int order)
    {
       OrdersEntity ordersEntity = (OrdersEntity)orderDao.findById(order);

        long workPeriod;
        long workPeriod1;
        long workPeriod2;

        if( compareMonth(timeDao.getEndTime(  ordersEntity.getTimeByTimeId().getId()) , timeDao.getBeginTime(  ordersEntity.getTimeByTimeId().getId())))
        {
            workPeriod = timeDao.getEndTime(  ordersEntity.getTimeByTimeId().getId()) -timeDao.getBeginTime(  ordersEntity.getTimeByTimeId().getId());

            Calendar a = Calendar.getInstance();

            a.setTime(new Date(ordersEntity.getTimeByTimeId().getBegin().getTime()));
      int month = a.get(Calendar.MONTH);
            String date1 ="01/"+ month+"/2016";
          Timestamp monthOfDrv =  TimeUtil.convertStringToTimestamp(date1);
           for(DriverEntity c : driverDao.getDriversByOrder(ordersEntity.getId()))
           {
               c.setTimeStatus(c.getTimeStatus()+workPeriod);
               driverDao.update(c);
               GenericClass<DriversplanEntity> genericClass = new GenericClass<DriversplanEntity>();
               genericClass.update(new DriversplanEntity(monthOfDrv,workPeriod,c.getId()));
           }


        }
        else
        {
            long fullperiod = timeDao.getEndTime(  ordersEntity.getTimeByTimeId().getId()) -timeDao.getBeginTime(  ordersEntity.getTimeByTimeId().getId());
            Calendar a = Calendar.getInstance();

            a.setTime(new Date(ordersEntity.getTimeByTimeId().getBegin().getTime()));
            int month1 = a.get(Calendar.MONTH);
            String date1 = "01/"+month1+"/2016";
            Calendar b = Calendar.getInstance();
            b.setTime(new Date(timeDao.getEndTime(ordersEntity.getTimeByTimeId().getId())));
            int month2 = b.get(Calendar.MONTH);
            String date2 = "01/"+month2+"/2016";
            workPeriod1 = notFullMonth( timeDao.getBeginTime(ordersEntity.getTimeByTimeId().getId()), timeDao.getEndTime(ordersEntity.getTimeByTimeId().getId()));
            workPeriod2 = fullperiod-workPeriod1;
            Timestamp monthOfDrv1 =  TimeUtil.convertStringToTimestamp(date1);
            Timestamp monthOfDrv2 =  TimeUtil.convertStringToTimestamp(date2);
            for(DriverEntity c : driverDao.getDriversByOrder(ordersEntity.getId()))
            {


                GenericClass<DriversplanEntity> genericClass = new GenericClass<DriversplanEntity>();
                genericClass.update(new DriversplanEntity(monthOfDrv1,workPeriod1,c.getId()));
                genericClass.update(new DriversplanEntity(monthOfDrv2,workPeriod2,c.getId()));
            }
        }


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







public DriverStatView getDriverStat(int driverId)
{
  int countOrder =  driverDao.getDoneOrder(driverId);
  double path = 0;
    long time = 0;
    float weight = 0;
  for(PathEntity a :  driverDao.getPathLengthStat(driverId))
  {
      path = path + a.getLength();
  }
  for(DriversplanEntity a : driverDao.getTimeStat(driverId) )
  {
      time = a.getWorkTime();
  }

  for(CargoEntity a: driverDao.getWeightStat(driverId))
  {
      weight= weight+ a.getWeight();
  }
    return new DriverStatView(countOrder,path,time, weight);
}






public int getDriverIdByLogin(String login)
{
   UserEntity u = userDao.getByDriverLogin(login);
    return u.getDriverId();
}










}