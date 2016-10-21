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
import java.util.ArrayList;

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
        String code = request.getParameter("userName");
        String ajax = request.getParameter("ajax");
        DriverService driverService = new DriverService();

if(ajax!=null) {

    String html = driverService.htmlTable(code);
    response.getWriter().write(html);
    response.getWriter().flush();
}
 else
{
    if(driverService.delDriver(code)) {
        request.setAttribute("driver", "Driver number " + code + "was deleted!");
    }
    else
    {
        request.setAttribute("driver", "Something is wrong!");

    }
    RequestDispatcher dispatcher = request.getRequestDispatcher("DelDriver.jsp");
    dispatcher.forward(request,response);

}






    }
}
