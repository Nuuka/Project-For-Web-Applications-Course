<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
        <title>Login Application</title>  
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    
    <body>  
    <div id="center">
        <div class="loginTitle">
            <h3>Post Story</h3>
        </div>
        <!--Form with option to post the story and the users 2 choices (overide width to default to center the textarea)-->
         <form action="newNodeServlet" method="post"  id="postStoryForm"> 
            <img id="img-circle" style="width:200px;height:200px;" src="">
            <br />
        	Choose a picture: <input type="file" id="filePicker">
			<script>
				var image =  document.getElementById('img-circle');
				if('<%=session.getAttribute("pictureString2")%>' == "null"){
					image.src = "images/no-Image.png";
				}else{
					image.src = 'data:image/png;base64,'+ '<%=session.getAttribute("pictureString2")%>';
				}
			</script>
			<br/>
            <p style="text-align:left;padding:8px;margin:0px;">Story:</p>
            <!--Main text area for the users Story-->
            <textarea name="postText" id="msg" style="resize:both" rows="8" cols="72"></textarea><br/>
            <!--Table to hold the 2 chocie text boxes-->
            <table style="margin-left: auto;margin-right:auto">
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
            <input id ="pictureText2" type="hidden" name="pictureText2" value="">
            <input type="submit" value="Submit" style="text-align: center">
            <!-- ---------- -->
		</form>
        	<script>
	        	
	        	var binaryString;
				var t;
				var p;
				var handleFileSelect = function(evt) {
				    var files = evt.target.files;
				    var file = files[0];
						
				    if (files && file) {
				        var reader = new FileReader();
				
				        reader.onload = function(readerEvt) {
				            binaryString = readerEvt.target.result;
				            t = btoa(binaryString.toString());
				            document.getElementById('pictureText2').value = t;
				            test();
				        };
				        reader.readAsBinaryString(file);
				        
				    }
				};
				
				if (window.File && window.FileReader && window.FileList && window.Blob) {
				    document.getElementById('filePicker').addEventListener('change', handleFileSelect, false);
				} else {
				    alert('The File APIs are not fully supported in this browser.');
				}
				
				function test(){
				  var image =  document.getElementById('img-circle');
				  image.src = 'data:image/png;base64,'+ t;
				}//window.location = "AccountServlet?pictureText2=test";
			</script>
    </div>    
    <%@include file="header/header.jsp" %>
    </body>  
</html>