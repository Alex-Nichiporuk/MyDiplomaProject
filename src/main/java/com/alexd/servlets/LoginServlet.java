package com.alexd.servlets;

import com.alexd.service.UserService;
import org.jboss.logging.Logger;

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
public class LoginServlet extends HttpServlet {



    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      java.util.Enumeration  a =  request.getParameterNames();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        HttpSession session = request.getSession();


        if (login == null || login.equals("")) {
            request.setAttribute("error", "user name field is empty");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
            return;
        }
        if (pass == null || pass.equals("")) {
            request.setAttribute("error", "password field is empty");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
            return;
        }
        UserService userService = new UserService();
       String answer = userService.checkUser(login,pass);
       if(answer.equals("error")) {
           request.setAttribute("error", answer);
           RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
           dispatcher.forward(request,response);
       }
       else
       {
           int role = userService.checkRole(login);
           if(role==3)
           {
               RequestDispatcher dispatcher = request.getRequestDispatcher("/DriverServlet");
               dispatcher.forward(request,response);

           }

           if(role == 2)
           {
               RequestDispatcher dispatcher = request.getRequestDispatcher("/ManagerServlet");
               dispatcher.forward(request,response);
           }
       }






    }
}
