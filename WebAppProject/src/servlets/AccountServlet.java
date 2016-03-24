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
		String pictureText = request.getParameter("pictureText");
		String id = request.getParameter("userId");
		AccountDao.updatePhoto(id, pictureText);
		System.out.println("ID:" + id);
		HttpSession session = request.getSession(false);  
        session.setAttribute("pictureString", pictureText);
		RequestDispatcher rd=request.getRequestDispatcher("account.jsp");    
        rd.forward(request,response);  
       
	}
}
