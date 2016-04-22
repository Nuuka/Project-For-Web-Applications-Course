package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

public class AccountServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1445677698640398231L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
		// set pictureText to the given string
		String pictureText = request.getParameter("pictureText");
		// set id to the given id
		String id = request.getParameter("userId");
		// update the photo to the new string
		AccountDao.updatePhoto(id, pictureText);
		HttpSession session = request.getSession(false);  
        session.setAttribute("pictureString", pictureText);
        // redirect back to account page
		RequestDispatcher rd=request.getRequestDispatcher("account.jsp");    
        rd.forward(request,response);  
	}
}
