package com.alexd.servlets;

import com.alexd.Validation.AddTruckValidator;
import com.alexd.Validation.AddValidator;
import com.alexd.service.DriverService;
import com.alexd.service.MapService;
import com.alexd.service.TruckService;
import com.alexd.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cj444 on 23.10.2016.
 */
public class AddTruckServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddTruck.jsp");
        dispatcher.forward(request,response);

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String number =  request.getParameter("Number");
        String size   =  request.getParameter("Size");
        String city = request.getParameter("City");
        String drivers = request.getParameter("Desc");

        String error;

        switch (AddTruckValidator.check(number, size, city, drivers))
        {
            case 1: error=" Number field is empty"; break;
            case 2: error=" Size field is empty"; break;
            case 3: error=" City field is empty"; break;
            case 4: error=" Drivers desc field is empty"; break;
            case 6: error=" Wrong city!"; break;
            case 7: error=" Number is not free"; break;
            default: error="";
        }


        if(error.equals("")) {
            TruckService truckService = new TruckService();
            MapService mapService = new MapService();
            String num = truckService.addTruck(number, Integer.parseInt(size),mapService.checkCity(city),true,Integer.parseInt(drivers));

            request.setAttribute("truck", "the truck " + num +  " has been added ");
        }
        else
        {
            request.setAttribute("error",  error);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("AddTruck.jsp");
        dispatcher.forward(request,response);




    }
}
