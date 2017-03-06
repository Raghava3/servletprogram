package con.ipl;

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


import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;


public class All  extends HttpServlet
{
	Connection con = null;
	PreparedStatement pstmt1 =null;
	Statement stm=null;
	ResultSet resultSet=null;
	int count1=0;
	private  Connection  jdbc()
	{

		try {


			Driver dref= new Driver();
			DriverManager.registerDriver(dref);

			String dburl= ("jdbc:mysql://localhost:3306/Raghava?user=root&password=root");
			con=DriverManager.getConnection(dburl);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{

		String s=req.getRequestURI();
		if(s.endsWith("register"))

		{
			String firstname=req.getParameter("firstname");
			String middlename=req.getParameter("middlename");
			String lastname=req.getParameter("lastname");
			String email=req.getParameter("email");
			String password=req.getParameter("pass");
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			Connection con=jdbc();

			String query1 ="insert into iplteam_signup values(?,?,?,?,?)";
			try 
			{
				pstmt1 = con.prepareStatement(query1);
				pstmt1.setString(1,firstname);
				pstmt1.setString(2,middlename);
				pstmt1.setString(3,lastname);
				pstmt1.setString(4,email);
				pstmt1.setString(5,password);
				count1 =pstmt1.executeUpdate();
				out.print(count1);
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
				if (resultSet != null) 
				{
					try
					{
						resultSet.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
			if(count1==1)
			{

				//System.out.println("com");
<<<<<<< HEAD
			/*	out.print("	<html>");
=======
				out.print("	<html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439
				out.print("<head>");
				out.print("<title>");
				out.print("JavaScript Automatic Page Redirect");
				out.print("</title>");        	
				out.print("	<script type='"+"text/javascript'>");
				out.print("function pageRedirect()");
				out.print("	    {");
				out.print("   window.location.replace('"+"login.html'"+")");
				out.print("    }  ");    
				out.print("setTimeout('"+"pageRedirect()'"+")");
				out.print("		</script>");
				out.print("</head>");
<<<<<<< HEAD
				out.print("</html>");*/
				resp.sendRedirect("login.html");
=======
				out.print("</html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439

			}
			else
			{

				//System.out.println("com");
<<<<<<< HEAD
				/*out.print("	<html>");
=======
				out.print("	<html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439
				out.print("<head>");
				out.print("<title>");
				out.print("JavaScript Automatic Page Redirect");
				out.print("</title>");        	
				out.print("	<script type='"+"text/javascript'>");
				//		out.print("function pageRedirect()");
				out.print("	    {");
				out.print("   window.location.replace('"+"register.html'"+")");
				out.print("    }  ");    
				//		out.print("setTimeout('"+"pageRedirect()'"+")");
				out.print("		</script>");
				out.print("email alredy in use");
				out.print("</head>");
				out.print("</html>");
<<<<<<< HEAD
*/
				resp.sendRedirect("register.html");
=======

>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439
			}
		}


		else if(s.endsWith("form" ))
		{


			String mail=req.getParameter("email");
			String password=req.getParameter("pass");

			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();

			Connection con=jdbc();
			String query2 ="select firstname from iplteam_signup where email like ? and password like ?";
			try {

				pstmt1 = con.prepareStatement(query2);

				pstmt1.setString(1,mail);
				pstmt1.setString(2,password);

				resultSet =pstmt1.executeQuery();



				if (resultSet.next())

				{
<<<<<<< HEAD
					/*out.print("	<html>");
=======
					out.print("	<html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439
					out.print("<head>");
					out.print("<title>");
					out.print("JavaScript Automatic Page Redirect");
					out.print("</title>");        	
					out.print("	<script type='"+"text/javascript'>");
					out.print("function pageRedirect()");
					out.print("	    {");
					out.print("   window.location.replace('"+"first.html'"+")");
					out.print("    }  ");    
					out.print("setTimeout('"+"pageRedirect()'"+")");
					out.print("		</script>");
					out.print("</head>");
<<<<<<< HEAD
					out.print("</html>");*/
					resp.sendRedirect("first.html");
=======
					out.print("</html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439

				}

				else 
				{
					//	System.out.println(" email and password is not matching ");

<<<<<<< HEAD
					/*out.print("	<html>");
=======
					out.print("	<html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439
					out.print("<head>");
					out.print("<title>");
					out.print("JavaScript Automatic Page Redirect");
					out.print("</title>");        	
					out.print("	<script type='"+"text/javascript'>");
					out.print("function pageRedirect()");
					out.print("	    {");
					out.print("   window.location.replace('"+"login.html'"+")");
					out.print("    }  ");    
					out.print("setTimeout('"+"pageRedirect()'"+")");
					out.print("email and password is not matching");
					out.print("		</script>");
					out.print("</head>");
<<<<<<< HEAD
					out.print("</html>");*/
					resp.sendRedirect("login.html");
=======
					out.print("</html>");
>>>>>>> 9073ae47a2679c5b79a4b73fe1b1b0a76b5e7439

				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
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
					if (resultSet != null) 
					{
						try
						{
							resultSet.close();
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
}

