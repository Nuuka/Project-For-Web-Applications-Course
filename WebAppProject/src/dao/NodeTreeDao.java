package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  
/**
 * This class deals with nodes.
 * 
 * @author Mohamed Ashour
 * @version 1.0
 */
public class NodeTreeDao { 
	/**
	 * Connects to the database and adds a new node to the nodes table.
	 * 
	 * @version 1.0
	 * @param text The main text of the new node
	 * @param choice1 The text in choice1
	 * @param choice2 The text in choice2
	 * @param node_id The id of the new node, this was for debugging purposes only and will be removed later
	 * @param pictureText 
	 * @param choice1_id The id of the node connecting to choice1, this was for debugging purposes only and will be removed later
	 * @param choice2_id The id of the node connecting to choice2, this was for debugging purposes only and will be removed later
	 * @return True if the function was successful, otherwise false
	 */
    public static List<String[]> generateTree() {          
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        List<String[]> nodes = new ArrayList<String[]>(); //arraylist of nodes
        
        //Variables for connecting to database
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";  
        
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
            int count = 1;
            while(true){
            	String[] nodeInfo  = new String[4]; //array to be put in arraylist
	            pst = conn.prepareStatement("SELECT choice1_id,choice2_id,text FROM form.ct_nodes where id = ?");
	            pst.setInt(1, count);
	            rs = pst.executeQuery();
	            if (!rs.next() ) {
	            	break;
	            }
	            nodeInfo[0] = "" + count;
	            nodeInfo[1] = rs.getString(1);
	            nodeInfo[2] = rs.getString(2);
	            nodeInfo[3] = rs.getString(3);

	            nodes.add(nodeInfo);
	            count++;
            }
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return nodes;  
    }
    
}  