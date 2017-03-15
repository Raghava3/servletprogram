<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
list of users  are
<%ArrayList al=(ArrayList)request.getAttribute("firstname");

for(Object al1:al)
{%>
	<br> <% out.println(al1.toString());%>
<% }%>

<form action="list" method="get"> 
<pre>
<bold>enter the name to serch full details :<input type="text" name="firstname" placeholder="enter the name to serch the database"> 
 <input type ="submit" value ="submit">
</pre>

</body>
</html>