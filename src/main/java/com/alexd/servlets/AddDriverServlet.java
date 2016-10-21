package com.alexd.servlets;

import com.alexd.Validation.AddValidator;
import com.alexd.service.DriverService;
import com.alexd.service.MapService;
import com.alexd.service.UserService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cj444 on 19.10.2016.
 */
public class AddDriverServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddDriver.jsp");
        dispatcher.forward(request,response);

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        java.util.Enumeration  a =  request.getParameterNames();
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        String lastname =  new String(request.getParameter("lastname").getBytes("ISO-8859-1"),"utf-8");
        String city = new String(request.getParameter("city").getBytes("ISO-8859-1"),"utf-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String error;

        switch (AddValidator.check(name, lastname, city, login, password))
        {
            case 1: error=" Name field is empty"; break;
            case 2: error=" Last name field is empty"; break;
            case 3: error=" City field is empty"; break;
            case 4: error=" Login field is empty"; break;
            case 5: error=" Password field is empty"; break;
            case 6: error=" Wrong city!"; break;
            case 7: error=" Login is not free"; break;
                default: error="";
        }


        if(error.equals("")) {
            DriverService driverService = new DriverService();
            MapService mapService = new MapService();
            driverService.addDriver(name, lastname, mapService.checkCity(city));
            UserService userService = new UserService();
            userService.addUser(login, password, name, lastname, 3);
            request.setAttribute("driver", "the driver " + name + " " + lastname + " has been added ");
            }
            else
        {
            request.setAttribute("error",  error);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("AddDriver.jsp");
        dispatcher.forward(request,response);




    }
}
