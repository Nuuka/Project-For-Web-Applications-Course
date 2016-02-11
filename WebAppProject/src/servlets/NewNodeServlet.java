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
        String node_id = request.getParameter("node_id");
        String choice1_id = request.getParameter("choice1_id");
        String choice2_id = request.getParameter("choice2_id");
        
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        	session.setAttribute("postText", pText);  
  
        
        if(NewNodeDao.validate(pText, choice1, choice2, node_id, choice1_id, choice2_id)){    
            RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
            rd.forward(request,response);    
        }    
        else{    
            RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
            rd.forward(request,response);    
        }    
  
        out.close();    
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	
    	String node[];
    	String nodeid = request.getParameter("nodeid");
    	
    	
    	node = NewNodeDao.getNode(Integer.parseInt(nodeid));
    	request.setAttribute("text", node[0]);
    	request.setAttribute("choice1", node[1]);
    	request.setAttribute("choice2", node[2]);
    	request.setAttribute("choice1_id", node[3]);
    	request.setAttribute("choice2_id", node[4]);
    	
    	//TODO: Create a if to check if the node came back null if it did forward to an error page.
    	RequestDispatcher rd=request.getRequestDispatcher("nodeview.jsp");    
        rd.forward(request,response);  
    }
}   