package com.bar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Registration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
	
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		//server side validation
		boolean b=true;
		if(name.equals(""))
		{
			out.print("name is required");
			b=false;
		}
			if(email.equals(""))
			{
				out.print("mail req");
			b=false;
			}
				if(address.equals(""))
				{
					out.print("add req	");
			b=false;
					}
		
				if(b==true)
				{
					
					System.out.println("forward to next");
				/*	Registraionservlet registration=(Registraionservlet)getServletContext().getServlet("com.bar.Registraionservlet");
					registration.doGet(request, response);
*/// here we are passing the url pattern if u see webxml page u will understand
			RequestDispatcher rd=request.getRequestDispatcher("/next"); 
					rd.forward(request, response);
					
				}
				
		}

	

}
