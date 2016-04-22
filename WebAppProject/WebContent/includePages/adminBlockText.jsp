<!-- If the user is an admin -->
<!-- This shows the block that allows the admin to edit the node and block it -->
        <div style="width=100%;text-align:center;background-color:#e74c3c;padding-top:10px;padding-bottom:10px;">
        	<h2 style="border:0px;margin:0px;padding:0px;color:white;">Admin Tools</h2>
	        <form action="ViewNodeServlet" method="post" name="adminTools">
	           	<input id="nodeid" type="hidden" name="nodeid" value="">
	       	  	<input id="true" type="radio" name="isBlocked" value="true" checked onclick='document.adminTools.submit()'> Blocked
				<input id="false" type="radio" name="isBlocked" value="false" onclick='document.adminTools.submit()'> Not Blocked<br>
	           	<input id="submitButton" type="submit" value=submit style="visibility:hidden;">
	           	
	        </form>
	        <%@include file="editPage.jsp" %>
        </div>
		<script>
           	if("<%=request.getAttribute("text")%>" == "This Story has be blocked by an Admin."){
           		document.getElementById('true').setAttribute("checked","checked");
           	}else{
           		document.getElementById('false').setAttribute("checked","checked");
           	}
           	document.getElementById('nodeid').setAttribute("value","<%=request.getAttribute("CurrentNode")%>");
        </script>