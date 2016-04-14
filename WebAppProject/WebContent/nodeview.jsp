
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>  

    <div id="center">
	    
    	<p width="100%" style="color:#bdc3c7;border:0px;margin:0px;padding:0px;text-align:right;">Number of views: <%=request.getAttribute("numOfViews")%><br/>
    	Created by: <%=request.getAttribute("nodeCreator")%></p>
        <p width="100%" style="border:0px;margin:0px;padding:0px;text-align:right;">
	        <img id="upvote" width="50px" height="50px" src="./images/upvote.png" onclick="document.getElementById('downvote').setAttribute('style','opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50)');
	        document.getElementById('upvote').setAttribute('style','opacity:1.0; -moz-opacity:1.0; filter:alpha(opacity=100)');
	        document.getElementById('choice 1').setAttribute('href','ViewNodeServlet?nodeid='+${choice1_id}+'&vote=up');
	        document.getElementById('choice 2').setAttribute('href','ViewNodeServlet?nodeid='+${choice2_id}+'&vote=up');">
	        <img id="downvote" width="50px" height="50px" src="./images/downvote.png" onclick="document.getElementById('upvote').setAttribute('style','opacity:0.5; -moz-opacity:0.5; filter:alpha(opacity=50)');
	        document.getElementById('downvote').setAttribute('style','opacity:1.0; -moz-opacity:1.0; filter:alpha(opacity=100)');
	        document.getElementById('choice 1').setAttribute('href','ViewNodeServlet?nodeid='+${choice1_id}+'&vote=down');
	        document.getElementById('choice 2').setAttribute('href','ViewNodeServlet?nodeid='+${choice2_id}+'&vote=down');">
        </p>
        <div class="loginTitle">
            <h3 style="line-height: 30px;color:black;">Here's what this node says...</h3>
        </div>
        <%
		if(session.getAttribute("accType")!= null){
			if(session.getAttribute("accType").equals("admin")){
				%><%@include file="./includePages/adminBlockText.jsp"%><%
			}
		}
		%>
        <form id="postStoryForm">
            <table id="imageTable" class="nodeViewTextTable" style="height:45%;">
            	<tr id="imageRow">
            		<td id="imageTD"><img id="img-circle" style="width:200px;height:200px;" src="">
						<script>
							var image =  document.getElementById('img-circle');
							var imageString = '<%=request.getAttribute("nodePictureString")%>';
							image.src = 'data:image/png;base64,'+ imageString;
							if(imageString == 'null' || imageString == ""){
								document.getElementById('imageTD').removeChild(image);
								document.getElementById('imageRow').removeChild(document.getElementById('imageTD'));
								document.getElementById('imageTable').deleteRow(0);
							}
							
						</script>
					</td>
            	</tr>
                <tr>
                    <td id="shadow" style="">
                      	${text}
                    </td>
                </tr>
            </table>
           
            <table class="nodeViewTextTable" style="margin-top:50px; height:30%">
                <tr>
                    <td>
                        <a id="choice 1" href="ViewNodeServlet?nodeid=${choice1_id}" class="nodeViewNodeTextBox">
                       		${choice1}
                        </a>
                        
                    </td>
                    <td style="width:14px">
	                </td>  
                   <td>
                        <a id="choice 2" href="ViewNodeServlet?nodeid=${choice2_id}" class="nodeViewNodeTextBox">
                        	${choice2}
                        </a>
                        
                    </td>  
                </tr>
                <tr style="height:40px;">
                	<%if(session.getAttribute("loginState") == "1"){ %>
						<%@include file="nodeview/loggedIn.jsp" %>
					<%}else{%> 
						<%@include file="nodeview/notLoggedIn.jsp" %>
					<%}%>
                </tr>
            </table>
        </form>
        <%
        	if(request.getAttribute("nodeCreator").equals(session.getAttribute("loginAccount"))){
        		out.println("hiiii");
        	}
        %>
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
    </div>
	<script>
		if(<%=request.getAttribute("choice1_id")%>==0){
			document.getElementById('choice 1').setAttribute("style",'pointer-events: none;cursor: default;');
		}
		if(<%=request.getAttribute("choice2_id")%>==0){
			document.getElementById('choice 2').setAttribute("style",'pointer-events: none;cursor: default;');
		}
	</script>
    <%@include file="header/header.jsp" %>
    </body>  
</html>  