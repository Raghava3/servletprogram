package newassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListOFUser extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		JdbcHelper jdbcHelper=new JdbcHelper();
	    	PrintWriter out=resp.getWriter();
	    	
		     String name= req.getParameter("firstname");
		    System.out.println(name);
		     ArrayList  all=jdbcHelper.listOfUser(name);
			    
	    	 req.setAttribute("name", all);
	    	
    	   RequestDispatcher rd=req.getRequestDispatcher("details.jsp");
    	     rd.include(req, resp); 
     	}
}
