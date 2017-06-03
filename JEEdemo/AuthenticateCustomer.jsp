<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="LoginErrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<body>
<%@include file="Header.jsp" %>
<jsp:include page="Header.jsp"></jsp:include>
<br>
<font face="Gabriola" size=10>
<br>
<%
String user=request.getParameter("uname");
int id=Integer.parseInt(user);
String pass=request.getParameter("password");
if(id==1010&&pass.equals("tech123"))
{
	out.print("login successful..");
}
else
{
	out.print("login unsuccessfull...");
}
%>




</font>
</body>
</html>