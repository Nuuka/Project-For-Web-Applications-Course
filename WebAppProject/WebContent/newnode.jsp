<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
		<title>New Node Submission</title>  
		<link rel="stylesheet" type="text/css" href="main.css">
	</head>  
	<body>  
		<div class="header">
		    <form action="newNodeServlet" method="post"> 
			    <table width="100%" style="padding:0px">  
			    	<tr>
			    		<td><input type="text" name="postText"  required="required" style="width: 744px; height: 123px"/> 
			            <td><input type="text" name="choice1"  required="required" style="width: 272px; height: 76px"/></td> 
			            <td><input type="text" name="choice2" required="required" style="height: 77px; width: 242px"/></td>   
			            <td><input type="submit" value="Submit" class="button" /></td> 
			        </tr>  
			    </table> 
		    </form> 
	    </div>
	</body>  
</html>  