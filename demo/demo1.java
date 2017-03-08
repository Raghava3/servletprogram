import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class demo1 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();

String firstname=req.getParameter("firstname");
String middlename=req.getParameter("middlename");
String lastname=req.getParameter("lastname");
pw.println("Welcome "+(firstname+middlename+lastname));
}
}