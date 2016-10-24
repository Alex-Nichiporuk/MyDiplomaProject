package com.alexd.servlets;

import com.alexd.service.OrderService;
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
public class AddOrderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddOrder.jsp");
        dispatcher.forward(request,response);

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderService orderService = new OrderService();
        SessionContainer s = SessionContainer.get(request.getSession());

        String param = request.getParameter("ajax");
        if(param.equals("cargo"))
        {
            String cargoWeight = request.getParameter("cargoW");
            if(cargoWeight!=null&&!cargoWeight.equals(""))
            {
                String cargoName = request.getParameter("cargoN");
                String cargoStatus = request.getParameter("cargoS");
              int id =  orderService.addCargo(cargoName,cargoWeight);
                s.getCargosId().put(id,cargoStatus);
                String cargo = orderService.htmlCargo();
                response.getWriter().write(cargo);
                response.getWriter().flush();

            }
            else
            {
                String point = request.getParameter("cityname");
                s.setCurrentPoint(point);
                String cargo = orderService.htmlCargo();
                response.getWriter().write(cargo);
                response.getWriter().flush();
            }
        }
else{
    String ans="";
    if(s.getCurrentPoint()!=null)
    {
        ans = s.getCurrentPoint();
    }

            String points = orderService.htmlPoints(ans);
    response.getWriter().write(points);
        response.getWriter().flush();
}




    }
}

