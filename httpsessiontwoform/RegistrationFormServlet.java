package com.bar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegistrationFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession hs=request.getSession();
Connection con=null;
PrintWriter out=response.getWriter();
		String fno=request.getParameter("fno");
	if(fno.equals("1"))
	{
		String firstname=request.getParameter("fname");
		String middlename=request.getParameter("middlename");
		String lastname=request.getParameter("lastname");
	hs.setAttribute("firstname", firstname);
	hs.setAttribute("middlename", middlename);
	hs.setAttribute("lastname", lastname);
	response.sendRedirect("form2.html");
	}
	else if(fno.equals("2"))
	{
		
		String email=request.getParameter("email");
		String othermail=request.getParameter("otheremail");
		
	hs.setAttribute("email", email);
	hs.setAttribute("othermail", othermail);
	
	String firstname=(String)hs.getAttribute("firstname");
	String middlename=(String)hs.getAttribute("middlename");
	String lastname=(String)hs.getAttribute("lastname");
  PreparedStatement preparedStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		  String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";// sql query 
		  con=DriverManager.getConnection(dburl);
		  
		  String query="insert into differentform value (?,?,?,?,?)";
		  preparedStatement=con.prepareStatement(query);
		  
		  preparedStatement.setString(1,firstname);
		  preparedStatement.setString(2,middlename);
		  preparedStatement.setString(3,lastname);
		  preparedStatement.setString(4,email);
		  preparedStatement.setString(5,othermail);

		  
	      int n=preparedStatement.executeUpdate();
	      
	      if(n==1)
	      {
	    	  System.out.println("sucessfully created");
	    	  out.print("sucessfully created");
	      }
	}
	catch ( Exception e)
	{
		System.out.println(e);
		
	}
	finally
	{
			
			if(con!=null)
			{	
				try
				{
				con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{	
				try
				{
				preparedStatement.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			   
		     }

				
			}

	}
	
	
	

	}	
}
