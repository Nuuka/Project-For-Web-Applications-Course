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
											opacity: 0.5;">&nbsp;</div>
<div id="popUpBlock" style="z-index: 3;visibility: hidden;left:calc(50% - 175px);position: fixed;">
	<%@include file="../includePages/login.jsp" %>
</div>
<script>
	function showLogin() {
	    document.getElementById("black").style.visibility='visible';
	    document.getElementById("popUpBlock").style.visibility='visible';
	}
	function hideLogin() {
		document.getElementById("black").style.visibility='hidden';
	    document.getElementById("popUpBlock").style.visibility='hidden';
	}
</script>
<div id="header">
    <!-- <form action="loginServlet" method="post"> -->
	    <table width="70%" style="margin-left:15%;text-align:center" height="63px">  
	    	<tr>
	    		<td onclick="location.href = 'index.jsp';" width="10%" style="text-align:left">
					<img src="logo.png" alt="logo" width="42" height="42">
				</td>
	    		<td class="option" width="10%" style="cursor:default">
		    			Adventure
		    			<div id="dropDownList">
		    			<ul>
		    				<li onclick="location.href = 'nodeTree.jsp';">Community Adventure</li>
		    				<li>Personal Adventure</li>
	    				</ul>
		    		</div>
    			</td>
    			<td class="option" width="10%" id="pop" style="cursor:pointer">
		    		Popular
    			</td>
    			<td class="option" width="10%" id="stat" style="cursor:pointer">
		    		Stats
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
    <!-- </form> -->
</div>


 <div id="footer">
   <div id="google_translate_element"></div>
   <script type="text/javascript">
   function googleTranslateElementInit() {
     	new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
     	
   }
   </script>
   <script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
   
</div>

