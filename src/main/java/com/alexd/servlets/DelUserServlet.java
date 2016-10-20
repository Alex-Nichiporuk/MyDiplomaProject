package com.alexd.servlets;

import com.alexd.service.DriverService;
import com.alexd.service.MapService;
import com.alexd.service.UserService;
import com.alexd.view.util.DriverView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Driver;

/**
 * Created by Cj444 on 19.10.2016.
 */
public class DelUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("DelDriver.jsp");
        dispatcher.forward(request,response);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String string = request.getParameter("username");


        int number = Integer.parseInt(string);

        DriverService driverService = new DriverService();
       DriverView driverView = driverService.getById(number);
        String name = driverView.getName()+" "+driverView.getLastname();


      response.getWriter().write(name);
        response.flushBuffer();




    }
}
