package com.alexd.servlets;

import com.alexd.Validation.AddTruckValidator;
import com.alexd.Validation.AddValidator;
import com.alexd.service.DriverService;
import com.alexd.service.MapService;
import com.alexd.service.TruckService;
import com.alexd.util.man.SessionContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cj444 on 23.10.2016.
 */
public class EditTruckServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditTrucks.jsp");
        dispatcher.forward(request,response);

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SessionContainer sessionContainer = SessionContainer.get(request.getSession());
        String code = request.getParameter("truckNum");
        String ajax = request.getParameter("ajax");
        TruckService truckService = new TruckService();

        if(ajax!=null) {
            String html = "Something is wrong";
            if(!ajax.equals("edit")) {
                html = truckService.htmlTruckTable(code);
            }
            else
            {
                sessionContainer.setEditTruck(truckService.getTruckById(code));
                html = truckService.htmlEditTruck(code);
            }
            response.getWriter().write(html);
            response.getWriter().flush();
        }
        else
        {
            String number =  request.getParameter("Number");
            String size   =  request.getParameter("Size");
            String city = request.getParameter("City");
            String drivers = request.getParameter("Desc");
            String status = request.getParameter("Status");
            String error ="";


            switch (AddTruckValidator.checkWithStatus(number, size, city, drivers, status))
            {
                case 1: error=" Number field is empty"; break;
                case 2: error=" Size field is empty"; break;
                case 3: error=" City field is empty"; break;
                case 4: error=" Drivers desc field is empty"; break;
                case 6: error=" Wrong city!"; break;
                case 8: error=" Status field is empty!"; break;
                case 9: error=" Wrong argument in status field!"; break;
                case 7:
                    if(!sessionContainer.getEditTruck().getId().equals(number)) {
                        error = " Number is not free";

                    }
                    break;
                default: error="";

            }

            if(error.equals(""))
            {

                MapService mapService = new MapService();
                int cityId = mapService.checkCity(city);
              truckService.updateTruck(number,Float.parseFloat(size), cityId, status, Integer.parseInt(drivers));
                error="Truck number "+ sessionContainer.getEditTruck().getId()+" was changed";
                sessionContainer.setEditTruck(null);

            }

            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditTrucks.jsp");
            dispatcher.forward(request,response);

        }






    }


}
