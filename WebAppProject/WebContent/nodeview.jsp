
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>  
    <%@include file="header/header.jsp" %>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <div>
        <div class="loginTitle">
            <h3 style="line-height: 30px">Here's what this node says...</h3>
        </div>
        <form id="postStoryForm">
            <table class="nodeViewTextTable" style="height:45%;">
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
    </body>  
</html>  