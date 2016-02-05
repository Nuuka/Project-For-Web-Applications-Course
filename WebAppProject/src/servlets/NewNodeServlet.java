package servlets;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import dao.NewNodeDao;   
  
public class NewNodeServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String pText = request.getParameter("postText");    
        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        	session.setAttribute("postText", pText);  
  
        
        if(NewNodeDao.validate(pText, choice1, choice2)){    
            RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
            rd.forward(request,response);    
        }    
        else{    
            RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
            rd.forward(request,response);    
        }    
  
        out.close();    
    }
    
}   