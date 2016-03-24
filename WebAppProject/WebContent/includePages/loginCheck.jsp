<%if(session.getAttribute("loginState") != "1"){
	response.sendRedirect("index.jsp");
}%>