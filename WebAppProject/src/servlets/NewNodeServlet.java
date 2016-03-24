package servlets;  
  
import java.io.IOException;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import dao.NodeDao;   
 
/**
 * The servlet used for handling nodes.
 * 
 * @author Mohamed Ashour, Joey MacLean
 * @version 1.0
 */
public class NewNodeServlet extends HttpServlet{  
    private static final long serialVersionUID = 1L; 
    
    /**
	 * This function is called if a post request is sent to the servlet.
	 * It adds a new node to the database.
	 * 
	 * @version 1.0
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	int userid = 0, nodeChoice = 0, node_id = 0;
         
        //Grabs all the necessary variables for the node
        String pText = request.getParameter("postText");    
        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
        String pictureText = request.getParameter("pictureText");
       
        
        HttpSession session = request.getSession(false);  
        if(session!=null){
        	session.setAttribute("postText", pText);
        	userid = (int)session.getAttribute("userid");
        	nodeChoice = Integer.parseInt((String)session.getAttribute("nodeChoice"));
        	node_id = Integer.parseInt((String)session.getAttribute("node_id"));
        }
        System.out.println(nodeChoice);
  
        //Enters the node to the database
        if(NodeDao.validate(pText, choice1, choice2, node_id, userid, nodeChoice,pictureText)){    
            RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
            rd.forward(request,response);    
        }    
        else{    
            RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
            rd.forward(request,response);    
        }       
    }
    
    /**
	 * This function is called if a get request is sent to the servlet.
	 * it displays a node to the webpage
	 * 
	 * @version 1.0
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	
    	String nodeChoice = request.getParameter("nodeChoice");
    	HttpSession session = request.getSession(false);  
        if(session!=null)
        	session.setAttribute("nodeChoice", nodeChoice);
    	
    	RequestDispatcher rd=request.getRequestDispatcher("newnode.jsp");    
        rd.forward(request,response);  
    }
}   