package com.bar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Regform extends GenericServlet
{

	Connection con=null;
	PreparedStatement preparedStatement=null;
	@Override
	//overriding the init method and and servlet config
	public void init(ServletConfig config) throws ServletException 
	{
	     ServletContext s=config.getServletContext();
         String name=s.getInitParameter("name");
         System.out.println("name");
         System.out.println(config.getInitParameter("db1"));
         System.out.println(config.getInitParameter("db2"));
         System.out.println(config.getInitParameter("db3"));
    try {
	    Class.forName(name);
	    String str=config.getInitParameter("db3");
	    System.out.println(config.getInitParameter("db1")+config.getInitParameter("db2")+"&"+str);

	    con=DriverManager.getConnection(config.getInitParameter("db1")+config.getInitParameter("db2")+"&"+str) ;
        } 
        catch (ClassNotFoundException | SQLException e) 
         {
	     e.printStackTrace();
          }
	}

	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException 
			{
		
		      String name=req.getParameter("name");
		      String email=req.getParameter("email");
		
		      String query="insert into xml value(?,?,10)";
		     try {
		    	 preparedStatement=con.prepareStatement(query);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2,email);
			
				int n=preparedStatement.executeUpdate();
				if (n==1)
				{
				
					System.out.println(" updated");
				
			    } 
		     }
		     catch (SQLException e) {
				
				e.printStackTrace();
			}
		     
	       }

	@Override
	public void destroy() {
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
			con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		   
	     }

	}

}
