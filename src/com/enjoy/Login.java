package com.enjoy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Login extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		     String name= req.getParameter("name");
		     String password= req.getParameter("pass");
		
		     if(name.equals("raghava")&&password.equals("qwerty"))
		     {
		    	 HttpSession session =req.getSession();
		    	 session.setAttribute("username", name);
		    	 RequestDispatcher rd=req.getRequestDispatcher("welcome.jsp");
		    	 rd.forward(req, resp);
		     }

		     else
		     {
		    	 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		    	 rd.forward(req, resp);
		    	 
		    	 		
		     }
	}
	

}
