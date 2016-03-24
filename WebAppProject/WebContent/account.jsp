<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Strict//EN">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
		<meta http-equiv="cache-control" content="max-age=0" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
		<meta http-equiv="pragma" content="no-cache" />
		<title>Login Application</title>  
		<link rel="stylesheet" type="text/css" href="main.css">
	</head>  
	<body>  
		<%@include file="includePages/loginCheck.jsp" %>
		<div id="center">
			<%//@include file="includePages/nodeTree.jsp" %>
			<p>&nbsp;</p>
			<table border="1" width="100%">
				<tr>
					<td width="50%"><img id="img-circle" style="width:200px;height:200px;" src="">
						<script>var image =  document.getElementById('img-circle');
						image.src = 'data:image/png;base64,'+ '<%=session.getAttribute("pictureString")%>';</script></td>
					<td width="50%"><h2>Hello <%=session.getAttribute("loginAccount")%>!!</h2></td>
				</tr>
				<tr>
					<td style="text-align:right;padding-right:10px;">First Name</td>
					<td style="color:#d35400;"><%=session.getAttribute("firstName")%></td>
				</tr>
				<tr>
					<td style="text-align:right;padding-right:10px;">Last Name</td>
					<td style="color:#d35400;"><%=session.getAttribute("lastName")%></td>
				</tr>
				<tr>
					<td style="text-align:right;padding-right:10px;">Email</td>
					<td style="color:#d35400;"><%=session.getAttribute("email")%></td>
				</tr>
			</table>
			<label for="filePicker">Choose a file:</label><br>
        	<input type="file" id="filePicker">
        	<form action="AccountServlet" method="post">
				<input id ="pictureText" type="hidden" name="pictureText" value="">
				<input id ="userId" type="hidden" name="userId" value="">
				<input id = "submitButton" type="submit" name="submit" value=submit disabled>
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
				            document.getElementById('pictureText').value = t;
				            document.getElementById('userId').value = <%=session.getAttribute("userid")%>; 
				            document.getElementById("submitButton").disabled = false;
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
				}//window.location = "AccountServlet?pictureText=test";
			</script>
			<div id="google_translate_element"></div><script type="text/javascript">
			function googleTranslateElementInit() {
			  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
			}
			</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        
		</div>
		
		<%@include file="header/header.jsp" %>

		
		
		

	</body>  
</html>