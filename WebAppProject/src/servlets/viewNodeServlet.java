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

public class viewNodeServlet extends HttpServlet{  
	  
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
    	//retrieves the node from the server by id and sets the nodes attributes in the webpage
    	node = NewNodeDao.getNode(Integer.parseInt(nodeid));
    	request.setAttribute("text", node[0]);
    	request.setAttribute("choice1", node[1]);
    	request.setAttribute("choice2", node[2]);
    	request.setAttribute("choice1_id", node[3]);
    	request.setAttribute("choice2_id", node[4]);
    	
    	//TODO: Create a if to check if the node came back null if it did forward to an error page.
    	RequestDispatcher rd=request.getRequestDispatcher("viewNode.jsp");    
        rd.forward(request,response);  
    }
}  