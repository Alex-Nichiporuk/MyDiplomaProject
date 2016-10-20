package com.alexd.servlets;

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
        DriverService driverService = new DriverService();
        MapService mapService = new MapService();
        int cityId = mapService.checkCity(city);
        driverService.addDriver(name, lastname, cityId);
        UserService userService = new UserService();
        userService.addUser(login,password, name,lastname,3);



       request.setAttribute("driver","the driver "+name+" "+lastname +" has been added " );
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddDriver.jsp");
        dispatcher.forward(request,response);




    }
}
