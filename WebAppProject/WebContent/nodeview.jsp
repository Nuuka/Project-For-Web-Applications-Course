<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>  
    <div class="header ">          
            <h1 style="text-align:center ">MiMoJo</h1>    
    </div>
    <div class="displayBlock" >
        <div class="loginTitle">
            <h3 style="line-height: 30px">Play</h3>
        </div>
        <form id="postStoryForm">
            <table  style=" table-layout: fixed; width: 800px; height:250px; margin-left: 300px; text-align:center">
                <tr>
                    <td style="width: 790px;  word-wrap:break-word; color: #ffffff; vertical-align:top ">
                      	${text}
                    </td>
                </tr>
            </table>
            <table style=" table-layout: fixed; width:800px; height:50px; margin-left: 300px; text-align: center; margin-top: 50px;">
                <tr>
                    <td style="width:383px">
                        <a href="http://localhost:8080/WebAppProject/ViewNodeServlet?nodeid=${choice1_id}" style="color:white; word-wrap:break-word; text-decoration: none;">
                            <div class="choice1">
                       			${choice1}
                            </div>
                        </a>
                        <a class="button" href="http://localhost:8080/WebAppProject/newNodeServlet?nodeChoice=1"> Create Node</a>
                    </td>
                    <td style="width:14px">
	                </td>  
                   <td style="width:383px">
                        <a href="http://localhost:8080/WebAppProject/ViewNodeServlet?nodeid=${choice2_id}" style="color:white; word-wrap:break-word; text-decoration: none;">
                            <div class="choice2">
                               ${choice2}
                            </div>
                        </a>
                    </td>  
                </tr>
            </table>
        </form>
    </div>
    </body>  
</html>  