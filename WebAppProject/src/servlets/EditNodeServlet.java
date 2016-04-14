package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NodeDao;

public class EditNodeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
    	response.setContentType("text/html");      
    	String nodeid = request.getParameter("nodeid");  
    	
    	
        if(request.getParameter("update") != null){
        	String pText = request.getParameter("postText");    
            String choice1 = request.getParameter("choice1");
            String choice2 = request.getParameter("choice2");
            String pictureText = request.getParameter("pictureText2");
        	NodeDao.editNode(nodeid,pText,choice1,choice2,pictureText);
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.forward(request,response); 
        }else{  
            String choice1id = request.getParameter("choice1 id");   
            String choice2id = request.getParameter("choice2 id");   
            String text = request.getParameter("text");   
            String choice1text = request.getParameter("choice1 text");   
            String choice2text = request.getParameter("choice2 text");   
            String pictureText = request.getParameter("pictureText");
            ////////////////////////////////////////////
	        request.setAttribute("node",nodeid);
	        request.setAttribute("choice1id",choice1id);
	        request.setAttribute("choice2id",choice2id);
	        request.setAttribute("text",text);
	        request.setAttribute("choice1text",choice1text);
	        request.setAttribute("choice2text",choice2text);
	        request.setAttribute("pictureText",pictureText);
	        RequestDispatcher rd=request.getRequestDispatcher("editNode.jsp");    
	        rd.forward(request,response);  
        }
            
   
    }
}
