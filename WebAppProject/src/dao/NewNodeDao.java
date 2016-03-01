package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
/**
 * This class deals with nodes.
 * 
 * @author Mohamed Ashour
 * @version 1.0
 */
public class NewNodeDao { 
	/**
	 * Connects to the database and adds a new node to the nodes table.
	 * 
	 * @version 1.0
	 * @param text The main text of the new node
	 * @param choice1 The text in choice1
	 * @param choice2 The text in choice2
	 * @param node_id The id of the new node, this was for debugging purposes only and will be removed later
	 * @param choice1_id The id of the node connecting to choice1, this was for debugging purposes only and will be removed later
	 * @param choice2_id The id of the node connecting to choice2, this was for debugging purposes only and will be removed later
	 * @return True if the function was successful, otherwise false
	 */
    public static boolean validate(String text, String choice1, String choice2, int node_id, int user_id, int nodeChoice) {          
        boolean status = true;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        
        //Variables for connecting to database
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";  
        
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
  
            
            pst = conn.prepareStatement("INSERT INTO form.ct_nodes (text, choice1_text, choice2_text, root_id, user_id) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, text);  
            pst.setString(2, choice1);
            pst.setString(3, choice2);
            pst.setInt(4, node_id);
            pst.setInt(5, user_id);
  
            pst.execute();
            
            if(nodeChoice == 1){
            	PreparedStatement pst2 = conn.prepareStatement("UPDATE form.ct_nodes parent INNER JOIN form.ct_nodes child ON parent.id = child.root_id SET parent.choice1_id = child.id WHERE parent.id = ?");
            	pst2.setInt(1, node_id);
            	pst2.execute();
            }else if (nodeChoice == 2){
            	PreparedStatement pst2 = conn.prepareStatement("UPDATE form.ct_nodes parent INNER JOIN form.ct_nodes child ON parent.id = child.root_id SET parent.choice2_id = child.id WHERE parent.id = ?");
                pst2.setInt(1, node_id);
                pst2.execute();
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
        return status;  
    }
	/**
	 * Connects to the database and retrieves a node by id from the nodes table.
	 * 
	 * @version 1.0
	 * @param nodeid the id of the node to retrieve
	 * @return an array of strings containing the node's text
	 */
    public static String[] getNode(int nodeid){
    	Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        String[] node = new String[5];
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";
        
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
  
            
            pst = conn.prepareStatement("SELECT text, choice1_text, choice2_text, choice1_id, choice2_id FROM form.ct_nodes WHERE id = ?");
            pst.setInt(1, nodeid);
  
            rs = pst.executeQuery();
            rs.next();
            node[0] = rs.getString(1);
            node[1] = rs.getString(2);
            node[2] = rs.getString(3);
            node[3] = rs.getString(4);
            node[4] = rs.getString(5);
            
            //node[1] = rs.getString("choice1_text");
  
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
        return node;
    }
    
}  