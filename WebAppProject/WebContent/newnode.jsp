<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    
    <body>  
    <!--Basic user form to add their parts of the story as well as their two choices-->
    <%@include file="header/header.jsp" %>
        <!--Main frame for the contents-->
    <div class="postBlock" >
        <div class="loginTitle">
            <h3 style="line-height: 175px">Post Story</h3>
        </div>
        <!--Form with option to post the story and the users 2 choices (overide width to default to center the textarea)-->
         <form action="newNodeServlet" method="post"  id="postStoryForm"> 

           
            
            <label for="msg"  >Story:</label><br/>
            <!--Main text area for the users Story-->
            <textarea name="postText" id="msg" style="resize:both" rows="8" cols="72"></textarea><br/>
            <!--Table to hold the 2 chocie text boxes-->
            <table style="margin-left: 50px;">
                <tr>
                    <td style="color: #ffffff">
                        <label  style="color:#ffffff" for="msg">Choice 1:</label><br/>
                        <textarea name="choice1" id="msg" style="resize:both"rows="4" cols="35"></textarea>
                        <!--temp html-->
                        
                    </td>
                    <td style="color: #ffffff">
                        <label style="color:#ffffff" for="msg">Choice 2:</label><br/>
                        <textarea name="choice2" id="msg" style="resize:both"rows="4" cols="34"></textarea>
                        <!--temp html-->
                        
                    </td>
                </tr>

            </table>
            <!--Submit button-->
            <input type="submit" value="Submit" style="text-align: center">
        </form>
    </div>
    </body>  
</html>