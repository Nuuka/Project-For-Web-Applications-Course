package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NodeTreeDao;

public class NodeTreeServlet  extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<String[]> nodes = new ArrayList<String[]>();
    	nodes = NodeTreeDao.generateTree();
    	request.setAttribute("nodeTreeObject", nodes);
    	request.setAttribute("nodeCount", nodes.size());
    	
    	HttpSession session = request.getSession(false);  
        if(session!=null)  
        	 session.setAttribute("node_id", request.getParameter("nodeid"));
    	
    	
    	RequestDispatcher rd=request.getRequestDispatcher("nodeTree.jsp");    
        rd.forward(request,response);  
    }
}
