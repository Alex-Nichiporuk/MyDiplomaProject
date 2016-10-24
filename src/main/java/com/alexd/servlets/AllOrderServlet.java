package com.alexd.servlets;

import com.alexd.service.DriverService;
import com.alexd.service.OrderService;

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
public class AllOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderService orderService = new OrderService();
        request.setAttribute("order", orderService.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("AllOrders.jsp");
        dispatcher.forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        OrderService orderService = new OrderService();
        request.setAttribute("order", orderService.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("AllOrders.jsp");
        dispatcher.forward(request,response);



    }
}
