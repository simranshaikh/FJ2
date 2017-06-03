<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
PrintWriter pw=response.getWriter();
//load the driver
Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("driver loaded successfully");
//since class not found exception: reason: .jar file not present

//step 2:get the connection		
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
System.out.println("connected successfully");
//Scanner sc=new Scanner(System.in);

//step 3:create ststement
Statement st = con.createStatement();

String s1=request.getParameter("empno");

String query="select * from emp where id="+s1+" ";

ResultSet rs=st.executeQuery(query);

pw.print("<table border=1>");

while(rs.next())
{
	pw.print("<tr>");
pw.print("<td>"+rs.getInt(1)+"</td>");
pw.print("<td>"+rs.getString(2)+"</td>");
pw.print("<td>"+rs.getString(3)+"</td>");
}

pw.print("</table>");

%>
</body>
</html>