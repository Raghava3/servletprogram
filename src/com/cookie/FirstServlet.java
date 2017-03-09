package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FirstServlet extends HttpServlet 
{

	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		
	PrintWriter out=resp.getWriter();
	String str =req.getParameter("name");
		Cookie cookie=new Cookie("name", str);
 resp.addCookie(cookie);
 out.print("<html>");
 out.print("<body>");
 out.print("<form action='servlet2'>");  
 out.print("<input type='submit' value='go'>");  
 out.print("</form>");  
out.print("</body>");
out.print("</html>");
			}
 resp.sendRedirect("com.cookie.secondServlet");
*/

	public void doPost(HttpServletRequest request, HttpServletResponse response){  
	    try{  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("userName");  
	    out.print("Welcome "+n);  
	  
	    Cookie ck=new Cookie("name",n);//creating cookie object  
	    response.addCookie(ck);//adding cookie in the response  
	  
	    //creating submit button  
	    out.print("<form action='servlet2'>");  
	    out.print("<input type='submit' value='go'>");  
	    out.print("</form>");  
	          
	    out.close();  
	  
	        }catch(Exception e){System.out.println(e);}  
	  }  

}

