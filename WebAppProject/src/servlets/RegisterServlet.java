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
import dao.RegisterDao;   
  
public class RegisterServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        	session.setAttribute("name", n);  

        if(RegisterDao.validate(n, p)){    
        	System.out.println("YESSSSSSSSS");
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            rd.forward(request,response);    
        }    
        else{    
        	System.out.println("NOOOOOOOOOOOO");
        	out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp");    
            rd.include(request,response);  
        } 

  
        out.close();    
    }
    
}   