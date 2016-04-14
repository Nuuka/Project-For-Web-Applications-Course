        <div style="width=100%;text-align:center;background-color:#e74c3c">
        	<h2 style="border:0px;margin:0px;padding:0px;color:white;">Admin Tools</h2>
	        <form action="ViewNodeServlet" method="post">
	           	<input id="nodeid" type="hidden" name="nodeid" value="">
	       	  	<input id="true" type="radio" name="isBlocked" value="true" checked> Blocked
				<input id="false" type="radio" name="isBlocked" value="false"> Not Blocked<br>
	           	<input id="submitButton" type="submit" name="submit" value=submit>
	        </form>
        </div>
		<script>
           	if("<%=request.getAttribute("text")%>" == "This Story has be blocked by an Admin."){
           		document.getElementById('true').setAttribute("checked","checked");
           	}else{
           		document.getElementById('false').setAttribute("checked","checked");
           	}
           	document.getElementById('nodeid').setAttribute("value","<%=request.getAttribute("CurrentNode")%>");
        </script>