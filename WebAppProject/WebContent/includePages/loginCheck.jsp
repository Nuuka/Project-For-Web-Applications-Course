<!-- this page is include to check if the user is logged in -->

<%if(session.getAttribute("loginState") != "1"){
	response.sendRedirect("index.jsp");
}%>