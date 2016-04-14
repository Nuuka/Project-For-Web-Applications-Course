        <form action="EditNodeServlet" method="post">
       		<input id="nodeid" type="hidden" name="nodeid" value="<%=request.getAttribute("CurrentNode")%>">
       		<input id="choice1 id" type="hidden" name="choice1 id" value="">
       		<input id="choice2 id" type="hidden" name="choice2 id" value="">
       		<input id="text" type="hidden" name="text" value="">
       		<input id="choice1 text" type="hidden" name="choice1 text" value="">
       		<input id="choice2 text" type="hidden" name="choice2 text" value="">
       		<input id="pictureText" type="hidden" name="pictureText" value="">
           	<input id="submitButton" type="submit" name="submit" value="Edit this node">
        </form>
        <script>
        	document.getElementById('nodeid').setAttribute("value","<%=request.getAttribute("CurrentNode")%>");
        	document.getElementById('choice1 id').setAttribute("value","<%=request.getAttribute("choice1_id")%>");
        	document.getElementById('choice2 id').setAttribute("value","<%=request.getAttribute("choice2_id")%>");
        	document.getElementById('text').setAttribute("value","<%=request.getAttribute("text")%>");
        	document.getElementById('choice1 text').setAttribute("value","<%=request.getAttribute("choice1")%>");
        	document.getElementById('choice2 text').setAttribute("value","<%=request.getAttribute("choice2")%>");
        	document.getElementById('pictureText').setAttribute("value","<%=request.getAttribute("nodePictureString")%>");
        </script>