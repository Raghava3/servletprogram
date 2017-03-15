package newassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		     String name= req.getParameter("email");
		     String password= req.getParameter("password");
		     //calling jdbc helper class to connection and login validation
		     JdbcHelper jdbcHelper=new  JdbcHelper();
		     String validationvariable=jdbcHelper.loginvalidation(name, password);
		  
		      if(validationvariable.startsWith("11111"))
		     {
		    	 out.print("email and password is not matching");
		    	 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		    	 rd.forward(req, resp);
		    	 // resp.sendRedirect("Login.jsp");
		     }
		     else
		     {
		    	
		    	 ArrayList  al=jdbcHelper.list();
		    
		    	 req.setAttribute("firstname", al);
		    	
	    	   RequestDispatcher rd=req.getRequestDispatcher("ListOfUser.jsp");
	    	     rd.include(req, resp); 
	     	}
		    	
	     }
		    	
		     
	}
	


