package com.alexd.servlets;

import com.alexd.service.DriverService;
import com.alexd.service.DriverUI;
import com.alexd.service.UserService;
import com.alexd.view.util.DriverStatView;
import com.alexd.view.util.DriverUIView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cj444 on 16.10.2016.
 */
public class DriverServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        java.util.Enumeration  a =  request.getParameterNames();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        HttpSession session = request.getSession();

        DriverService driverService = new DriverService();
       int id = driverService.getDriverIdByLogin(login);
        DriverUIView driverUIView = new DriverUI().getInfo(id);



        request.setAttribute("driver", driverUIView);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/driverui.jsp");
        dispatcher.forward(request,response);




    }



}
