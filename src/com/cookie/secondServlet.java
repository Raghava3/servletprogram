package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class secondServlet  extends   HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		String str=null;
		PrintWriter out=resp.getWriter();
		Cookie cookie[]=req.getCookies();
		for(Cookie c:cookie)
		{
			if(c.getName().equals("name"))
			{
				str=c.getValue();
			}
		}
	
		out.print("welcome"+str);
	}

}
