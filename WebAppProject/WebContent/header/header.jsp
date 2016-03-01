<div class="header">
    <form action="loginServlet" method="post"> 
	    <table width="100%" style="padding:0px">  
	    	<tr>
	    		<td rowspan="2">
					<img src="logo.png" alt="logo" width="42" height="42">
				</td>
	    		<td rowspan="2" width="70%" style="padding-top:9px;">
	    			<h1 style="text-align:center;">
		    			<a style="text-decoration: none;color: inherit; "href="index.jsp">
		    				MiMoJo
		    			</a>
	    			</h1>
    			</td>
		            <%if(session.getAttribute("loginState") == "1"){ %>
						<%@include file="loggedIn.jsp" %>
					<%}else{%> 
						<%@include file="notLoggedIn.jsp" %>
					<%}%>
	        </tr>  
	    </table> 
    </form> 
</div>