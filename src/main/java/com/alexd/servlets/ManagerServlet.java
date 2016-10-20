package com.alexd.servlets;

import com.alexd.service.DriverService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cj444 on 18.10.2016.
 */
public class ManagerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerUI.jsp");
        dispatcher.forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();
        DriverService driverService = new DriverService();
        request.setAttribute("driver", driverService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ManagerUI.jsp");
        dispatcher.forward(request,response);




    }
}
