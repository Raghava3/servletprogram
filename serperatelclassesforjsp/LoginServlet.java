package com.bar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
	     	PrintWriter out=resp.getWriter();
		     String name= req.getParameter("name");
		     String password= req.getParameter("pass");
		     //calling jdbc helper class to connection and login validation
		     JdbcHelper jdbcHelper=new  JdbcHelper();
		     String validationvariable=jdbcHelper.loginvalidation(name, password);
		     System.out.println(validationvariable);
		     System.out.println     (validationvariable.startsWith("11111"));
		      if(validationvariable.startsWith("11111"))
		     {
		    	 out.print("email and password is not matching");
		    	 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		    	 rd.forward(req, resp);
		     }
		     else
		     {
		    	 HttpSession session =req.getSession();
	    	     session.setAttribute("name", validationvariable);
	    	     RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
	    	     rd.forward(req, resp);
	    	   /*  System.out.println("i am coming");
	    	     resp.sendRedirect("welcome.jsp");*/
	     }
		    	
		     
	}
	

}