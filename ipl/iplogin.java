package ipl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class iplogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
			{
		
	//	 req.getRequestDispatcher("iplsignup.html").include(req, resp);  
		
		String mail=req.getParameter("email");
		String password=req.getParameter("pass");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
	//	out.print(false);
		Connection con = null;
		PreparedStatement pstmt =null;
	ResultSet rs=null;
	
	try {
		
		// loading the driver 
//		Class.forName("com.jdbc.mysql.Driver");
		String query2 ="select firstname from iplteam_signup where email like ? and password like ?";
		Class.forName("com.mysql.jdbc.Driver");//
		//get the connection through the driver 
		String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
		con=DriverManager.getConnection(dburl);
		
	
	    pstmt = con.prepareStatement(query2);
		pstmt.setString(1,mail);
		pstmt.setString(2,password);
		rs =pstmt.executeQuery();
		
if (rs.next())
			
		{
			String username=rs.getString(1);
			
			System.out.println(" welcome "+username);
			
			
			out.print("	<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("JavaScript Automatic Page Redirect");
			out.print("</title>");        	
			out.print("	<script type='"+"text/javascript'>");
			out.print("function pageRedirect()");
			out.print("	    {");
			out.print("   window.location.replace('"+"firstpage.html'"+")");
			out.print("    }  ");    
			out.print("setTimeout('"+"pageRedirect()'"+")");
			out.print("		</script>");
			out.print("</head>");
			out.print("</html>");

			
			
		}
		else 
		{
			System.out.println(" email and password is not matching ");
			
			out.print("	<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("JavaScript Automatic Page Redirect");
			out.print("</title>");        	
			out.print("	<script type='"+"text/javascript'>");
			out.print("function pageRedirect()");
			out.print("	    {");
			out.print("   window.location.replace('"+"Login.html'"+")");
			out.print("    }  ");    
			out.print("setTimeout('"+"pageRedirect()'"+")");
			out.print("		</script>");
			out.print("</head>");
			out.print("</html>");
			
		}
	}
catch (SQLException |ClassNotFoundException e) 
{
e.printStackTrace();
}
    
finally{
	
		if (con != null) 
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
		if (pstmt != null) 
		{
		try
			{
			pstmt.close();
		   }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		}
		
	
	
	}


	}
}

