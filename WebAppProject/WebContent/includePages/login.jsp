<div id="loginBlock" >
    <div class="loginTitle">
        <h3 style="line-height: 175px">Login</h3>
    </div>
    <!--Form for login, user and password-->
    <form style="margin-left:75px" action="loginServlet" method="post">
    	
        User ID<br/><input type="text" name="username" required="required" ><br/>
        Password<br/><input type="password" name="userpass" required="required" ><br/><br/>
        <input type="submit" value="Login" style="margin-left: 65px">
        <% if(session.getAttribute("loginState") == "2"){ 
			out.println("<br /><span style=\"color:#e74c3c\">Invalid username or password!</span>");
		}%>
    </form>
   
</div>