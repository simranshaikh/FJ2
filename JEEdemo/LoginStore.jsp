<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		PrintWriter pw = response.getWriter();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//pw.print("driver loaded successfully");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		//pw.print("connected successfully");
		Statement st = con.createStatement();

		String u = request.getParameter("user");
		String p = request.getParameter("pwd");
		String query = "select * from LOGIN where USERNAME=' " + u
				+ " ' and PASSWORD=' " + p + " '";
		ResultSet rs = st.executeQuery(query);
		int n = 0;
		while (rs.next()) {
			if (rs.getString(1).equalsIgnoreCase(u)
					&& rs.getString(2).equals(p)) {
				n = 1;

			}
		}
		if (n == 0) {
			pw.print("login unsuccessfull");
		} else {
			pw.print("login successfull");
		}
	%>
</body>
</html>