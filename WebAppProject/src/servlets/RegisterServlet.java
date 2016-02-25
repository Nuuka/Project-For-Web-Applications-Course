package servlets;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import dao.RegisterDao;   

/**
 * The servlet used for register requests.
 * 
 * @author Joey MacLean
 * @version 1.0
 */
public class RegisterServlet extends HttpServlet{  
  
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
        String username =request.getParameter("username");    
        String password =request.getParameter("userpass");  
        String firstName=request.getParameter("firstName");    
        String lastName=request.getParameter("lastName"); 
        String email=request.getParameter("email");
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        	session.setAttribute("name", username);  

        //If the validation is successful redirects to welcome, otherwise redirects to register
        if(RegisterDao.createAccount(username, password, firstName, lastName, email)){    
        	//System.out.println("YESSSSSSSSS");
            RequestDispatcher rd=request.getRequestDispatcher("login.jsp");    
            rd.forward(request,response);    
        }    
        else{    
        	//System.out.println("NOOOOOOOOOOOO");
        	session.setAttribute("createStatus", "failed");  
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp");    
            rd.include(request,response);  
        } 

  
        out.close();    
    }
    
}   