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
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
         
        //Grabs all the necessary variables for the node
        String pText = request.getParameter("postText");    
        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
        String node_id = request.getParameter("node_id");
        String choice1_id = request.getParameter("choice1_id");
        String choice2_id = request.getParameter("choice2_id");
        
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        	session.setAttribute("postText", pText);  
  
        //Enters the node to the database
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
    
    /**
	 * This function is called if a get request is sent to the servlet.
	 * it displays a node to the webpage
	 * 
	 * @version 1.0
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {
    	
    	String node[];
    	//The nodeid parameter is located in the url of the webpage
    	String nodeid = request.getParameter("nodeid");
    	//retrieves the node from the server by id and sets the nodes attributes in the webpage
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