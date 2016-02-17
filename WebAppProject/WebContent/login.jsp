<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
	    <title>Login Application</title>  
	    <link rel="stylesheet" type="text/css" href="main.css">
	    <% if(session.getAttribute("loginStatus") == "success"){ 
				out.println("<meta http-equiv=\"refresh\" content=\"0; url=index.jsp\" />");
			}
				 
		%>
    </head>
    <body> 
    <!--very basic login page with two fields for a username and password aswell as a login button--> 
    <div class="header ">          
            <h1 style="text-align:center ">MiMoJo</h1>    
    </div>
    	<!-- Main frame to hold contents-->
        <div class="loginBlock" >
            <div class="loginTitle">
                <h3 style="line-height: 175px">Login</h3>
            </div>
            <!--Form for login, user and password-->
            <form style="margin-left:75px" action="loginServlet" method="post">
            	
                User ID<br/><input type="text" name="username" required="required" ><br/>
                Password<br/><input type="password" name="userpass" required="required" ><br/><br/>
                <input type="submit" value="Login" style="margin-left: 65px">
                <% if(session.getAttribute("loginStatus") == "failed"){ 
					out.println("<br /><span style=\"color:#e74c3c\">Invalid username or password!</span>");
				}
				 
				%>
            </form>
           
        </div>
    </body>  
</html>  