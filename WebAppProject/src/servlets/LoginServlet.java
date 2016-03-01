package servlets;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import dao.LoginDao;   
/**
 * The servlet used for login requests.
 * 
 * @author Joey MacLean
 * @version 1.0
 */
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
    
    /**
	 * This function is called if a post request is sent to the servlet
	 * 
	 * @version 1.0
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
         
        //Grabs the username and password for the request
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        	session.setAttribute("name", n);  
        
        //If the validation is successful redirects to index, otherwise redirects to the same page letting the user know it was unsuccessful 
        int id = LoginDao.validate(n, p);
        if(id != 0){    //success
        	session.setAttribute("loginState", "1");
        	session.setAttribute("loginAccount", n);
        	session.setAttribute("userid",id );
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.forward(request,response);    
        }    
        else{    //failed
        	session.setAttribute("loginState", "2");
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");    
            rd.forward(request,response);    
        }    
  
        out.close();    
    }
    
}   