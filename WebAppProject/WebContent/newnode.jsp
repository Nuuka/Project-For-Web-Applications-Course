<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>New Node Submission</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    
    <body>  
    <div class="header ">          
            <h1 style="text-align:center ">MiMoJo</h1>    
    </div>
        <div class="postBlock" >
            <div class="loginTitle">
                <h3 style="line-height: 175px">Post Story</h3>
            </div>
            <form action="newNodeServlet" method="post" style="text-align: center; width: auto ! important;"> 
                <label for="msg" >Message:</label><br/>
                <textarea id="msg" name="postText" style="resize:both" rows="8" cols="72"></textarea><br/>
                <table style="margin-left: 45px">
                    <tr>
                        <td>
                            <label for="msg">Message:</label><br/>
                            <textarea id="msg" name="choice1" style="resize:both"rows="4" cols="35"></textarea>
                        </td>
                        <td>
                            <label for="msg">Message:</label><br/>
                            <textarea id="msg" name="choice2" style="resize:both"rows="4" cols="35"></textarea>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Submit" style="text-align: center">
            </form>
        </div>
    </body>  
</html>