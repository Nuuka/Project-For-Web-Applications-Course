
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>  

    <div id="center">
        <div class="loginTitle">
            <h3 style="line-height: 30px;color:black;">Here's what this node says...</h3>
        </div>
        <form id="postStoryForm">
            <table id="imageTable" class="nodeViewTextTable" style="height:45%;">
            	<tr id="imageRow">
            		<td id="imageTD"><img id="img-circle" style="width:200px;height:200px;" src="">
						<script>
						var image =  document.getElementById('img-circle');
						var imageString = '<%=request.getAttribute("nodePictureString")%>';
						image.src = 'data:image/png;base64,'+ imageString;
						
						if(imageString == 'null'){
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
                        <a href="ViewNodeServlet?nodeid=${choice1_id}" class="nodeViewNodeTextBox">
                       		${choice1}
                        </a>
                        
                    </td>
                    <td style="width:14px">
	                </td>  
                   <td>
                        <a href="ViewNodeServlet?nodeid=${choice2_id}" class="nodeViewNodeTextBox">
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
    </div>
    
    <%@include file="header/header.jsp" %>
    </body>  
</html>  