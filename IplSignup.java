package ipl;

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

import com.mysql.jdbc.Driver;

public class IplSignup extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		//getting the form data
		String firstname=req.getParameter("firstname");
		String middlename=req.getParameter("middlename");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
        resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Connection con = null;
		PreparedStatement pstmt1 =null;



		try {

			// loading the driver 
			//	Class.forName("com.jdbc.mysql.Driver");

			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			//get the connection through the driver 
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";
			con=DriverManager.getConnection(dburl);

			String query1 ="insert into iplteam_signup values(?,?,?,?,?)";
			pstmt1 = con.prepareStatement(query1);
			pstmt1.setString(1,firstname);
			pstmt1.setString(2,middlename);
			pstmt1.setString(3,lastname);
			pstmt1.setString(4,email);
			pstmt1.setString(5,password);
			int count1 =pstmt1.executeUpdate();





			if(count1==1){
				out.println("Successfully created in database");
				//this is for giving the link 
				/*out.print("<html>");
        out.print("<body>");*/
				//      out.print("<a href='" +	"Login.html'>clik here to login</a>");
				/*    out.print("</a>");
        out.print("</body>");
        out.print("</html>");*/


				// this is to redirect to without giving the link 

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
			else{
				out.println("Unsuccessful to create in database");
			}
		} 
		catch (SQLException e) 
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
			if (pstmt1 != null) 
			{
				try
				{
					pstmt1.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}

			}



		}
		//End of inner Try-catch block
			}//End of Finally Block	
}




