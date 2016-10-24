package com.alexd.servlets;

import com.alexd.Validation.AddValidator;
import com.alexd.service.DriverService;
import com.alexd.service.MapService;
import com.alexd.util.man.SessionContainer;
import com.alexd.view.util.UserView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cj444 on 22.10.2016.
 */
public class EditServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditDriver.jsp");
        dispatcher.forward(request,response);

    }




    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SessionContainer sessionContainer = SessionContainer.get(request.getSession());
        String code = request.getParameter("userName");
        String ajax = request.getParameter("ajax");
        DriverService driverService = new DriverService();

        if(ajax!=null) {
String html = "Something is wrong";
            if(!ajax.equals("edit")) {
                  html = driverService.htmlTable(code);
                 }
            else
            {
                sessionContainer.setEditUser(driverService.getDriverByDriverId(code));
                  html = driverService.editHtmlDriver(code);
            }
            response.getWriter().write(html);
            response.getWriter().flush();
        }
        else
        {
            String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
            String lastname =  new String(request.getParameter("lastname").getBytes("ISO-8859-1"),"utf-8");
            String city = new String(request.getParameter("city").getBytes("ISO-8859-1"),"utf-8");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String error ="";


            switch (AddValidator.check(name, lastname, city, login, password))
            {
                case 1: error=" Name field is empty"; break;
                case 2: error=" Last name field is empty"; break;
                case 3: error=" City field is empty"; break;
                case 4: error=" Login field is empty"; break;
                case 6: error=" Wrong city!"; break;
                case 7:
                    if(!login.equals(sessionContainer.getEditUser().getLogin()) ) {
                        error = " Login is not free";
                        break;
                    }
                default: error="";
            }

            if(error.equals(""))
            {
                if(password==null)
                {
                    password=sessionContainer.getEditUser().getPassword();
                }
                MapService mapService = new MapService();
                int cityId = mapService.checkCity(city);
                driverService.updateDriver(sessionContainer.getEditUser().getDriverId(),name,lastname, cityId,login,password, sessionContainer.getEditUser().getId() );
                error="Driver number "+ sessionContainer.getEditUser().getDriverId()+" was changed";
                sessionContainer.setEditUser(null);

            }

            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditDriver.jsp");
            dispatcher.forward(request,response);

        }






    }
}
