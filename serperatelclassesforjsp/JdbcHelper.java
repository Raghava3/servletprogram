package com.bar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class JdbcHelper {

	public Connection connection=null;
	public Statement statement=null;
	public  ResultSet  resultset=null;
	public PreparedStatement preparedStatement=null;
//method to connection
	public Connection connection()
	{
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
		String query="select firstname from login where email =? and password = ?";
		try
		{
			
			preparedStatement=	jdbcHelper.connection().prepareStatement(query);
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

