<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
int p_amt=Integer.parseInt(request.getParameter("principalamt"));
int no_of_years=Integer.parseInt(request.getParameter("period"));
int rate=Integer.parseInt(request.getParameter("rate"));
int si=(p_amt*no_of_years*rate)/100;
PrintWriter pw=response.getWriter();

pw.print("simple interest is "+si);
%>
</body>
</html>