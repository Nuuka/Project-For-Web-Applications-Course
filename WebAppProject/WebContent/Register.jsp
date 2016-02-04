<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
		<title>Login Application</title>  
		<link rel="stylesheet" type="text/css" href="main.css">
	</head>  
	<body>  
		<div style="height:30%">&nbsp;</div>
		<div class="header" style="height: 200px;width: 70%;margin-left: 20%;" >
		    <form action="RegisterServlet" method="post"> 
			    <table width="100%" style="padding:0px;height:100%">  
			    	<tr>
			    		<td width="50%"><h1 style="text-align:center">MiMoJo</h1></td>
			    		<td>
				    		<table>
				    			<tr>
				    				<td colspan="2" style="color:cyan">
				    					Please enter a user ID and Password to create an account
				    				</td>
				    			</tr>
				    			<tr>
				    				<td align="right">User ID:</td>
				    				<td><input type="text" name="username" placeholder="User ID" required="required" /></td>
				    			</tr>
				    			<tr>
				    				<td align="right">Password:</td>
				    				<td><input type="password" name="userpass" placeholder="Password" required="required" /></td>
				    			</tr>
				    		</table>
			    		</td>
			    	</tr>
			    	<tr>
			        	<td colspan="2" align="center"><input type="submit" value="Create Account" class="button" /></td> 
			        </tr>
			    </table> 
		    </form> 
	    </div>
	</body>  
</html>  