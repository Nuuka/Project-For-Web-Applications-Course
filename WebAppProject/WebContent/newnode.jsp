
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    
    <body>  
    <!--Basic user form to add their parts of the story aswell as their two choices-->
    <div class="header ">          
            <h1 style="text-align:center ">MiMoJo</h1>    
    </div>
        <!--Main frame for the contents-->
    <div class="postBlock" >
        <div class="loginTitle">
            <h3 style="line-height: 175px">Post Story</h3>
        </div>
        <!--Form with option to post the story and the users 2 choices (overide width to default to center the textarea)-->
         <form action="newNodeServlet" method="post"  id="postStoryForm"> 

            node currently editing: <input type="text" name="node_id"><br/>
            
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
                        id: <input type="text" name="choice1_id">
                    </td>
                    <td style="color: #ffffff">
                        <label style="color:#ffffff" for="msg">Choice 2:</label><br/>
                        <textarea name="choice2" id="msg" style="resize:both"rows="4" cols="34"></textarea>
                        <!--temp html-->
                        id: <input type="text" name="choice2_id">
                    </td>
                </tr>

            </table>
            <!--Submit button-->
            <input type="submit" value="Submit" style="text-align: center">
        </form>
    </div>
    </body>  
</html>