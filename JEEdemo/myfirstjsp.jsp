<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My JSP Page</title>
</head>
<body>
<H1>Hello...!!!</H1>
<%!
String user="shefali";
int counter=2;
%>
<B>WELCOME <%= user %></B>
<br>
<B>Today's date is:</B><%=new Date() %>
<br>
<%
for(int i=0;i<counter;i++)
{
%>
<B>Very</B>
<%
}
%>
Good Morning<br>
Have a great day...
</body>
</html>