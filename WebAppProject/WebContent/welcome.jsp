<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body bgcolor="#34495e">
	<h3>Login successful!!</h3>
    <h4>Welcome, <%=session.getAttribute("name")%></h4>  
</body>  
</html>  