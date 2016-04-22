



<!-- This Div is the black overlay when the login appears-->
<div id="black" onclick="hideLogin()" style="
	position:fixed;
	z-index: 2;
	box-shadow: 20px 20px 10px #888888;
	visibility: hidden;
	height:100%;
	width:100%;
	background-color:black;
	top: 0px;
	right: 0px;
	opacity: 0.5;">&nbsp;
</div>

<!-- Div for the popup for login -->
<div id="popUpBlock" style="z-index: 3;visibility: hidden;left:calc(50% - 175px);position: fixed;">
	<%@include file="../includePages/login.jsp" %>
</div>


<script>
	// Shows the black overlay and login block
	function showLogin() {
	    document.getElementById("black").style.visibility='visible';
	    document.getElementById("popUpBlock").style.visibility='visible';
	}
	// Hide the black overlay and login block
	function hideLogin() {
		document.getElementById("black").style.visibility='hidden';
	    document.getElementById("popUpBlock").style.visibility='hidden';
	}
</script>


<%
// If logged in as admin show the admin header
// If normal user, show the normal header
if(session.getAttribute("accType")!= null){
	if(session.getAttribute("accType").equals("admin")){
		out.println("<div id=\"headerAdmin\">");
	}else{
		out.println("<div id=\"header\">");
	}
}else{
	out.println("<div id=\"header\">");
}

%>
		<!-- main header table -->
	    <table width="70%" style="margin-left:15%;text-align:center" height="63px">  
	    	<tr>
	    		<td onclick="location.href = 'index.jsp';" width="10%" style="text-align:left">
					<img src="logo.png" alt="logo" width="42" height="42">
				</td>
	    		<td class="option" width="10%" style="cursor:pointer" onclick="location.href = './NodeTreeServlet';">
		    			Adventure
		    		</div>
    			</td>
    			<!-- <td class="option" width="10%" id="pop" style="cursor:pointer" onclick="location.href = './stats.jsp';">
		    		Statistics
    			</td>-->
    			<td class="option" width="10%" id="stat" style="cursor:pointer" onclick="location.href = './about.jsp';">
		    		About
    			</td>
    			<td width="50%">
		    		&nbsp;
    			</td>
    			
		            <%if(session.getAttribute("loginState") == "1"){ 
						out.println("<td class=\"option\" style=\"padding-right:5px;\" width=\"10%\" style=\"text-align:right;cursor:pointer\">Account");
						out.println("<div id=\"dropDownList\"><ul><li onclick=\"location.href = 'logout.jsp';\">logout</li><li onclick=\"location.href = 'account.jsp';\">View Account</li></ul></td>");
					}else{
						out.println("<td class=\"option\" style=\"padding-right:5px;\" width=\"10%\" onclick=\"showLogin()\" style=\"text-align:right;cursor:pointer\">Sign In</td>");
					}%>
	        </tr>  
	    </table> 
</div>


 <div id="footer">
	<div style="padding-top:25px;margin-top:0px;color:white;">
   		<div id="google_translate_element"></div>
   	</div>
   	
   <script type="text/javascript">
   function googleTranslateElementInit() {
     	new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
     	
   }
   </script>
   <script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
      <style>
		div#google_translate_element div.goog-te-gadget-simple{background-color:black;}
    	div#google_translate_element div.goog-te-gadget-simple a.goog-te-menu-value span{color:white}
    	div#google_translate_element div.goog-te-gadget-simple a.goog-te-menu-value span:hover{color:#ffffff}

	</style>
</div>

