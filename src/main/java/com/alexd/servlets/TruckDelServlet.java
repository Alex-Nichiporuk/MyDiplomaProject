package com.alexd.servlets;

import com.alexd.service.DriverService;
import com.alexd.service.TruckService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cj444 on 23.10.2016.
 */
public class TruckDelServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("DelTrucks.jsp");
        dispatcher.forward(request,response);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      java.util.Enumeration a =  request.getParameterNames();
        String code = request.getParameter("truckNum");
        String ajax = request.getParameter("ajax");
        TruckService truckService = new TruckService();

        if(ajax!=null) {

            String html = truckService.htmlTruckTable(code);
            response.getWriter().write(html);
            response.getWriter().flush();
        }
        else
        {
            if(truckService.deleteTruck(code)) {
                request.setAttribute("truck", "Truck number " + code + "was deleted!");
            }
            else
            {
                request.setAttribute("truck", "Something is wrong!");

            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("DelTrucks.jsp");
            dispatcher.forward(request,response);

        }






    }
}
