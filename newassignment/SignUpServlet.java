package newassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
	     	 PrintWriter out=resp.getWriter();
		     String fname= req.getParameter("fname");
		     String mname= req.getParameter("mname");
		     String lname= req.getParameter("lname");
		     String email=req.getParameter("email");
		     String password= req.getParameter("password");
		     //calling jdbc helper class to connection and login validation
		     JdbcHelper jdbcHelper=new  JdbcHelper();
		     int n=jdbcHelper.signUp(fname,mname,lname,email,password);
		   System.out.println("n"+n);
		     if(n==1)
		     {
		    	  resp.sendRedirect("Login.jsp");
		     }
		     else
		     {
		    	  resp.sendRedirect("SignUpServlet.jsp");
	    	 
	     }
	
	
}
}
