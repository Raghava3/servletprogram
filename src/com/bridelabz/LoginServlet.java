package com.bridelabz;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LoginServlet extends HttpServlet {  
	HttpSession session=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //this is to print link 
        request.getRequestDispatcher("link.html").include(request, response);  
        //  we cant use sendRedirect
    //	response.sendRedirect("link.html"); 
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          System.out.println(request);
        if(password.equals("admin123")){  
        out.print("Welcome, "+name);  
      session=request.getSession(); 
      session.invalidate();
      session.setMaxInactiveInterval(1*60);
      session.setAttribute("name",name);  
 

        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
       
        }  
        out.close();  
    }  
}  
