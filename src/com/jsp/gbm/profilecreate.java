package com.jsp.gbm;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.Driver;


public class profilecreate extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
			//getting the form data
		String regno = req.getParameter("regno") ;
		String sfnm = req.getParameter("SFirstName") ;
		String smnm = req.getParameter("SMiddleName") ;
		String slnm = req.getParameter("SLastName") ;
		String gfnm = req.getParameter("GFirstName") ;
		String gmnm = req.getParameter("GMiddleName");
		String glnm = req.getParameter("GLastName");
		String passkey =req.getParameter("pass");
		String isadmin = req.getParameter("isAdmin");
		
		//Dispalying form data into servlets
		
		System.out.println("regno :"+regno);
		System.out.println("SFirstName :"+sfnm);
		System.out.println("SMiddleName :"+smnm);
		System.out.println("SLastName :"+slnm);
		System.out.println("GFirstName :"+gfnm);
		System.out.println("GMiddleName :"+gmnm);
		System.out.println("GLastName :"+glnm);
		System.out.println("pass :"+passkey);
		System.out.println("isAdmin :"+isadmin);
		//Generate the Response
		
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				
				
				
				
		//Store the Form data into Database using JDBC
		Connection con = null;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2 =null;
		PreparedStatement pstmt3 =null;

		ResultSet rs=null;
		
		try {
			/*
			 *1.Load the Driver
			 * Driver Class :  com.mysql.jdbc.Driver
			 */
			
			//A.
			/*com.mysql.jdbc.Driver driverRef = new  com.mysql.jdbc.Driver();*/
			
			//B. 
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			//Both A and B are same
			
			/*
			 * 2.Get the "DB Connection" via "Driver"
			 */
				/* First version of overloading getConnection() 
			String dbUrl = "jdbc:mysql://localhost:3306/BECME91011_DB?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);*/
			
				// Second version of overloading getConnection() 
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
			 con = DriverManager.getConnection(dburl);
			 
			 System.out.println("pass :"+passkey);
			/*
			 * 3. Issue "SQL Queries" via "Connection"
			 */
			String query1 ="insert into student_info values(?,?,?,?)";
		    pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1,Integer.parseInt(regno));
			pstmt1.setString(2,sfnm);
			pstmt1.setString(3,smnm);
			pstmt1.setString(4,slnm);
			int count1 =pstmt1.executeUpdate();
			String queryS1 = "select * from student_info";
			//out.print("student_form_info: "+queryS1);
			
			
			String query2 ="insert into gaurdian_info values(?,?,?,?)";
		    pstmt2 = con.prepareStatement(query2);
			pstmt2.setInt(1,Integer.parseInt(regno));
			pstmt2.setString(2,gfnm);
			pstmt2.setString(3,gmnm);
			pstmt2.setString(4,glnm);
			int count2 =pstmt2.executeUpdate();
			String queryS2 = "select * from guardian_info";
			//out.print("guardian_form_info: "+queryS2);
			
			String query3 ="insert into studentother_info values(?,?,?)";
		    pstmt3 = con.prepareStatement(query3);
			pstmt3.setInt(1,Integer.parseInt(regno));
			pstmt3.setString(2,passkey);
			pstmt3.setString(3,isadmin);
			int count3 =pstmt3.executeUpdate();
			String queryS3 = "select * from studentother_info";
			//out.print("student_form_other_info: "+queryS3);
			
			/*
			 * 4. "Process the Results" returned by "SQL Queries"
			 */
			
			if(count1>0 && count2>0 && count3>0){
				out.println("Successfully created in database");
				
			}
			else{
				out.println("Unsuccessful to create in database");
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		//End of Outer Try-Catch Block
		finally{
			try{
				if (con != null) {
					con.close();
				}
				if (pstmt1 != null) {
					pstmt1.close();
				}
				if (pstmt2 != null) {
					pstmt2.close();
				}
				if (pstmt3 != null) {
					pstmt3.close();
				}
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			//End of inner Try-catch block
		}//End of Finally Block	
		}

}
