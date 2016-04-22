<!--
This page is shown when the user attempts to log in

 -->

<div id="loginBlock" >
    <div class="loginTitle">
        <h3 style="line-height: 175px">Login</h3>
    </div>
    <!--Form for login, user and password-->
    <div id="loginInfo">
	    <form action="loginServlet" method="post">
	    	
	        User ID<br/><input type="text" name="username" required="required" ><br/>
	        Password<br/><input type="password" name="userpass" required="required" ><br/><br/>
	        <input type="submit" value="Login">
	        <% if(session.getAttribute("loginState") == "2"){ 
				out.println("<br /><span style=\"color:#e74c3c\">Invalid username or password!</span>");
			}%>
			<hr class="onGreen"/>Need an account? <br /><a href="register.jsp" >Register here!</a>
	    </form>
    </div>
   
</div>