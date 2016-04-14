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
import dao.NodeDao;   
 
/**
 * The servlet used for handling nodes.
 * 
 * @author Mohamed Ashour, Joey MacLean
 * @version 1.0
 */
public class ViewNodeServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L; 
    
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
    	if(request.getParameter("vote") != null){
    		NodeDao.vote(request.getParameter("vote"),Integer.parseInt(request.getParameter("currentNode")));
    	}
    	
    	//retrieves the node from the server by id and sets the nodes attributes in the webpage
    	node = NodeDao.getNode(Integer.parseInt(nodeid));
    	request.setAttribute("text", node[0]);
    	request.setAttribute("choice1", node[1]);
    	request.setAttribute("choice2", node[2]);
    	request.setAttribute("choice1_id", node[3]);
    	request.setAttribute("choice2_id", node[4]);
    	request.setAttribute("nodePictureString", node[5]);
    	request.setAttribute("numOfViews", node[6]);
    	request.setAttribute("nodeCreator", node[7]);
    	request.setAttribute("votes", node[8]);
    	request.setAttribute("CurrentNode", nodeid);
    	
    	HttpSession session = request.getSession(false);  
        if(session!=null)  
        	 session.setAttribute("node_id", request.getParameter("nodeid"));
    	
    	//TODO: Create a if to check if the node came back null if it did forward to an error page.
    	RequestDispatcher rd=request.getRequestDispatcher("nodeview.jsp");    
        rd.forward(request,response);  
    }
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {  
    	
    	response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        String isBlocked = request.getParameter("isBlocked");  
        String nodeid = request.getParameter("nodeid");   
        if(isBlocked.equals("true")){
        	NodeDao.blockNode(Integer.parseInt(nodeid),true);
        }else{
        	NodeDao.blockNode(Integer.parseInt(nodeid),false);
        }
        request.setAttribute("node",nodeid);
        RequestDispatcher rd=request.getRequestDispatcher("./includePages/redirectToNode.jsp");    
        rd.forward(request,response);      
  
        out.close();    
    }
}   