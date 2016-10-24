package com.alexd.service;

import com.alexd.DAO.TruckDao;
import com.alexd.model.TruckEntity;
import com.alexd.view.util.TruckView;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cj444 on 11.10.2016.
 */
public class TruckService implements TruckServiceImpl{
    EntityManager em;
    TruckDao truckDao;
    public TruckService()
    {
                 truckDao = new TruckDao();
    }

    public boolean checkTruckNumber(String number)
    {
      TruckEntity a =  (TruckEntity)truckDao.findById(number);
        if(a==null)
        {
            return true;
        }
        return false;
    }

    public String addTruck(String id, int size, int city, boolean status, int driversize)
    {

        TruckEntity truckEntity = new TruckEntity(id, size,status, driversize ,city );
        GenericService<TruckEntity>genericService = new GenericService<TruckEntity>();
        genericService.add(truckEntity);
        return  truckEntity.getId();
    }

    public boolean updateTruck(String id, float size, int city, String status, int driversize)
    {
        boolean stat = false;
        if(status.equals("ok"))
        {
            stat=true;
        }
        try {

            truckDao.update(new TruckEntity(id, size,stat,  driversize ,city ));

        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }


    public boolean deleteTruck(String code)
    {
        try {
            truckDao.delete(code);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    private List<TruckEntity> selectAlldao()
    {
        try {

            List<TruckEntity> resultQuery = truckDao.selectAll( );


            return resultQuery;
        }
        catch (Exception e)
        {
            return null;
        }


    }

    public ArrayList<TruckView> selectAll()
    {
        ArrayList<TruckView> truckViews = new ArrayList<TruckView>();
        List<TruckEntity> truckEntities = selectAlldao();
        for(TruckEntity truckEntity : truckEntities)
        {
            truckViews.add(new TruckView(truckEntity));
        }
        return truckViews;
    }





    public String htmlTruckTable(String code)
    {
        List<TruckEntity> trucks  =   truckDao.getByNum(code);
        ArrayList<TruckView>truckViews = new ArrayList<TruckView>();
        for(TruckEntity a: trucks)
        {
            truckViews.add(new TruckView(a));
        }


        String htmlHead = "<table  id=\"table1\" class=\"table table-striped\" style=\"width: 100%\">\n" +
                "         <thead>\n" +
                "         <tr >\n" +
                "             <td>Number</td>\n" +
                "             <td style=\"width: 204px\">Size</td>\n" +
                "             <td style=\"width: 204px\">Status</td>\n" +
                "             <td>Driver desc</td>\n" +
                "             <td style=\"width: 204px\">Current city</td>\n" +
                "             <td>Busy status</td>\n" +

                "\n" +
                "         </tr>\n" +
                "         </thead>\n" +
                "\n";
        String data="";

        for(TruckView a : truckViews) {
            String status = "broke";
            if(a.getStatus())
            {
                status="ok";
            }
            String bStatus = "free";
            if(!a.getBusyStatus())
            {
                bStatus="busy";
            }
            data = data +


                    "             <tr onclick=\"choiceOf(this)\">\n" +
                    "                 <td>" + a.getId() + "</td>"+
                    "                 <td>" + a.getSize() + "</td>"+
                    "                 <td>" + status + "</td>"+
                    "                 <td>" + a.getDriverdesc() + "</td>"+
                    "                 <td>" + a.getCity() + "</td>"+
                    "                 <td>" + bStatus + "</td>"+

                    "             </tr>\n" ;

        }
        String htmlEnd =  "     </table>";
        return htmlHead+data+htmlEnd;
    }


    public TruckView getTruckById(String code)
    {
       return new TruckView((TruckEntity) truckDao.findById(code));
    }


    public String htmlEditTruck(String code)
    {
        TruckView truckView = new TruckView((TruckEntity) truckDao.findById(code));
        String status = "broke";
        if(truckView.getStatus())
        {
            status="ok";
        }
        String html = " <form method=\"post\" class=\"login-container\"  action=\"EditTruckServlet\">\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"email\" class=\"cols-sm-2 control-label\">Truck number</label>\n" +
                "                    <div class=\"cols-sm-10\">\n" +
                "                        <div class=\"input-group\">\n" +
                "                            <span class=\"input-group-addon\"><i class=\"fa fa-road fa\" aria-hidden=\"true\"></i></span>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"Number\" id=\"email\"  value=\""+truckView.getId() +"\"/>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"username\" class=\"cols-sm-2 control-label\">Truck size</label>\n" +
                "                    <div class=\"cols-sm-10\">\n" +
                "                        <div class=\"input-group\">\n" +
                "                            <span class=\"input-group-addon\"><i class=\"fa fa-star fa\" aria-hidden=\"true\"></i></span>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"Size\" id=\"username\"  value=\""+truckView.getSize() +"\"/>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"password\" class=\"cols-sm-2 control-label\">City</label>\n" +
                "                    <div class=\"cols-sm-10\">\n" +
                "                        <div class=\"input-group\">\n" +
                "                            <span class=\"input-group-addon\"><i class=\"fa fa-building-o fa-lg\" aria-hidden=\"true\"></i></span>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"City\" id=\"password\"  value=\""+truckView.getCity() +"\"/>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"confirm\" class=\"cols-sm-2 control-label\">Driver desc</label>\n" +
                "                    <div class=\"cols-sm-10\">\n" +
                "                        <div class=\"input-group\">\n" +
                "                            <span class=\"input-group-addon\"><i class=\"fa fa-users fa-lg\" aria-hidden=\"true\"></i></span>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"Desc\" id=\"confirm\"  value=\""+truckView.getDriverdesc() +"\"/>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"confirm\" class=\"cols-sm-2 control-label\">Status(broke/ok)</label>\n" +
                "                    <div class=\"cols-sm-10\">\n" +
                "                        <div class=\"input-group\">\n" +
                "                            <span class=\"input-group-addon\"><i class=\"fa fa-users fa-lg\" aria-hidden=\"true\"></i></span>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"Status\" id=\"confirm\"  value=\""+status +"\"/>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <span style=\"color: red\">\n" +
                "     <c:if test=\"${not empty error}\">\n" +
                "         <c:out value=\"${error}\"> </c:out>\n" +
                "     </c:if>\n" +
                "</span>\n" +
                "                <span style=\"color: green\">\n" +
                "<c:if test=\"${not empty truck}\">\n" +
                "    <c:out value=\"${truck}\"> </c:out>\n" +
                "</c:if>\n" +
                "\n" +
                "</span>\n" +
                "\n" +
                "   <input type=\"submit\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"OK\" style=\" margin: auto; ; float: left; font-size: 20px; width: 20% \"> </input>\n" +
                "    <input type=\"button\"   class=\"btn btn-primary btn-lg btn-block login-button\"  value=\"Cancel\" onclick=\"f()\" style=\" margin: 0% 0% 0% 80%;  font-size: 20px; width: 20% \"> </input> \n" +
                "\n" +
                "\n" +
                "            </form>";
        return html;
    }


}
