<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
	    <title>Login Application</title>  
	    <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <script type="text/javascript">
        function checkPass()
            {
        		//gets the id from the first password and the second password
		   		//and stores them into variables
                var pass1 = document.getElementById('pass1');
                var pass2 = document.getElementById('pass2');
                //grabs the id of tconfirm message
                var message = document.getElementById('confirmMessage');
                //storing the matched and non-matched password colors
                var matchColor = "#66cc66";
                var noMatchColor = "#ff6666";
              	//if the passwords match the background color chnages to green
			    //if they don't match it will turn red
                if(pass1.value == pass2.value){
               
                    pass2.style.backgroundColor = matchColor;
                    message.style.color = matchColor;
                    message.innerHTML = "Passwords Match!"
                }else{
                   
                    pass2.style.backgroundColor = noMatchColor;
                    message.style.color = noMatchColor;
                    message.innerHTML = "Passwords Do Not Match!"
                }
            } //end script 
    </script>
    <body> 
    <!--Basic register form only asking for username and password--> 
    <div class="header ">          
            <h1 style="text-align:center ">MiMoJo</h1>    
    </div>
        <!--Main frame-->
        <div class="registerBlock" >
            <div class="loginTitle">
                <h3 style="line-height: 175px">Register</h3>
            </div>
            <!--Form for user to input their username and password-->
            <form action="RegisterServlet" method="post"> 
                <label for="userID" >User ID</label>
                <input type="text" name="username"><br/>
 
                <label for="password" style="margin-top: 1em">Password</label>
                <input type="password" name="userpass" id="pass1"><br/><br/>
 
                <label for="password2">Confirm Password</label>
                <!--Calls on javascript fuction to check if the passwords are a match-->
                <input type="password" name="ConfirmPassword" id="pass2" onkeyup="checkPass(); return false">
                <span id="confirmMessage" class="confirmMessage" style="margin-left: 95px"></span><br/><br/>
 
                <input type="submit" value="Create Account" style="margin-left: 150px">
                <% if(session.getAttribute("createStatus") == "failed"){ 
					out.println("<br /><span style=\"color:#e74c3c\">Account already in use!</span>");
				}
				 
				%>
            </form>
        </div>
    </body>  
</html>  