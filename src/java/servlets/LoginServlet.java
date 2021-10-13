/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountServices;

/**
 *
 * @author 794974
 */
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         String username = request.getParameter("username");
       String logout = request.getParameter("logout");
       
       if(logout != null){
           session.invalidate();
           request.setAttribute("success", true);
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
          return;
           
       }else {
       
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
         User userObj = new User(username,password);
         
         request.setAttribute("userObj", userObj);
        
        
        // if field empty send error message else send the user to the home page 
        
        if(username.equals("") || username == null || password.equals("") || password == null ){
          request.setAttribute("userObj", userObj);
          request.setAttribute("errormessage", true);
          request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
          return;
        }else
        {
            AccountServices acc = new AccountServices();
           if(acc.login(userObj.getUsername(),userObj.getPassword()) != null){
          session.setAttribute("username", username);
          response.sendRedirect("home");
          return;
           }else{
               request.setAttribute("entrymessage", true);
               request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
          return;
           }
        }
    }


}
