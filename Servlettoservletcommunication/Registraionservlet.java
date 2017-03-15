package com.bar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registraionservlet
 */
public class Registraionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstm=null;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		PrintWriter out=response.getWriter();
		try{
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
			con= DriverManager.getConnection(dburl);
			   

			   
			    // issue sql query 
			    System.out.println("2");
			    String query ="insert into studet_info value(?,?,?)";
			    System.out.println("3");
			    pstm=con.prepareStatement(query);
			    pstm.setString(1,name);
				   pstm.setString(2,email);
				   pstm.setString(3,address);
				   System.err.println("4");
			      int n=pstm.executeUpdate();
			      if(n==1)
			      {
			    	  out.print("sucess");
			      }
			      else
			      {
			    	  out.print("false");
			      }
			
		}catch(Exception e)
		{
			
		}

	}

}
