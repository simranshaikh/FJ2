<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>An Exception Occured</h1>

<table>
<tr>
<td>Exception Class</td>
<td><%= exception.getClass() %></td>
</tr>

<tr>
<td>Message</td>
<td><%= exception.getMessage() %></td>
</tr>
</table>

</br>

To go to login page

<form name="f2" action="login2.html">
<input type="submit" value="Login page">

</form>
</body>
</html>