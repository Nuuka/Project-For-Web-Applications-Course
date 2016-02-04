<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
		<title>Login Application</title>  
		<link rel="stylesheet" type="text/css" href="main.css">
	</head>  
	<body>  
		<div class="header">
		    <form action="loginServlet" method="post"> 
			    <table width="100%" style="padding:0px">  
			    	<tr>
			    		<td rowspan="2" width="75%"><h1 style="text-align:center">MiMoJo</h1></td>
			    		<td style="width: 54px; ">User ID</td>
			    		<td>Password!</td> 
			    	</tr>
			        <tr>  
			            <td><input type="email" name="username" placeholder="Email" required="required" /></td> 
			            <td><input type="password" name="userpass" placeholder="Password" required="required" /></td>   
			            <td><input type="submit" value="Login" class="button" /></td> 
			        </tr>  
			    </table> 
		    </form> 
	    </div>
	</body>  
</html>  