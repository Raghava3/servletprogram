package newassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class JdbcHelper {

	public Connection connection=null;
	public Statement statement=null;
	public  ResultSet  resultset=null;
	public PreparedStatement preparedStatement=null;
  
//method to connection
	public Connection connection()
	{
		//JdbcHelper jdbcHelper=new  JdbcHelper();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/Raghava?user=root&password=root";// sql query 
			connection=DriverManager.getConnection(dburl);
		}
		catch (ClassNotFoundException |  SQLException e) 
		{

			e.printStackTrace();
		}
		return connection;
	}
//method to loginvalidation
	public String loginvalidation(String name , String password)
	{
		JdbcHelper jdbcHelper=new  JdbcHelper();
		String query="select firstname from login where email =? and password =?";
		try
		{
			Connection con=jdbcHelper.connection();
			preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultset=preparedStatement.executeQuery();
			if (resultset.next())
			{
				String username=resultset.getString(1);
				jdbcHelper.close();
				return username;
			}
			else 
			{
               jdbcHelper.close();
				return "11111";
			}
		}
		catch(SQLException e) 
		{
             jdbcHelper.close();
			e.printStackTrace();
		}
		return "11111";
	}
	
	public int signUp(String firstname,String middlename, String lastname, String email, String password)
	{
		JdbcHelper jdbcHelper=new  JdbcHelper();
		String query="insert into login values(?,?,?,?,?)";
		try
		{
			Connection con=jdbcHelper.connection();
			preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, middlename);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, password);
			int n =preparedStatement.executeUpdate();
			
           return n;
		} 
       	catch(SQLException e) 
		{
             jdbcHelper.close();
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList list()
	{
		//int n=0;
		// JavaBean  javaBean=new JavaBean();
	   ArrayList a=new ArrayList();
		String s="";
	//	String a[]=new String[100];
		try
		{
			  System.out.println("coming1");
		  String query="select firstname from login";
		  //creating the statement 
		//  System.out.println("coming");
		  JdbcHelper jdbcHelper=new  JdbcHelper();
		  Connection con=jdbcHelper.connection();
		  statement=con.createStatement();
	//	
		 
		 resultset = statement.executeQuery(query);
		// int i=0;
		   while( resultset.next())
			  {
			   
		  a.add(resultset.getString(1));
		//	 n=0;
		  
		   //  s=resultset.getString(1);
		   // javaBean.setFirstname(resultset.getString(1));
		    
		 // System.out.println( a[i]=s);
	      //i++;
	      }		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return a;
	}
	
	
	
	
	
	public ArrayList listOfUser(String name)
	{
		
	   ArrayList a=new ArrayList();
	//   String s=name; 	
	
		try
		{
		  String query="select * from login where firstname =?";
		
		  JdbcHelper jdbcHelper=new  JdbcHelper();
		  Connection con=jdbcHelper.connection();
		
		  preparedStatement=con.prepareStatement(query);
		  preparedStatement.setString(1, name);
	
		 
		 resultset = preparedStatement.executeQuery();
		
		   while( resultset.next())
			  {
		   a.add(resultset.getString(1));
	       a.add(resultset.getString(2));
		   a.add(resultset.getString(3));
		   a.add(resultset.getString(4));
		   a.add(resultset.getString(5));
	      }		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return a;
	}
	
	
	
	
	//method to close 
	public void close()
	{
		try{
			int n=	1/1;
		}
		catch(Exception e)
		{

		}
		finally
		{
			if(connection!=null)
			{	
				try
				{
					connection.close();
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

			if(resultset!=null)
			{
				try
				{
					resultset.close();
				}

				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if(statement!=null)
			{
				try
				{
					statement.close();
				}

				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}