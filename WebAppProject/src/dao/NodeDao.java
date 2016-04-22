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
public class NodeDao { 
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
	 */
    public static void newNode(String text, String choice1, String choice2, int node_id, int user_id, int nodeChoice, String pictureText) {            
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
  
            // Create new node
            pst = conn.prepareStatement("INSERT INTO form.ct_nodes (text, choice1_text, choice2_text, root_id, user_id, picture_string) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, text);  
            pst.setString(2, choice1);
            pst.setString(3, choice2);
            pst.setInt(4, node_id);
            pst.setInt(5, user_id);
            pst.setString(6, pictureText);
  
            pst.execute();
            
            if(nodeChoice == 1){
            	
            	
            	/* 
            	 * where the parents id = the variable node_id
            	 * Grab the parent node and store it as parent
            	 * Grab the child node and store it as child
            	 * where parent id = the child nodes root id
            	 * and child id does not equal parent choice2_id
            	 * set parent's choice 1 id to the child's id
            	 */
            	PreparedStatement pst2 = conn.prepareStatement("UPDATE form.ct_nodes parent INNER JOIN form.ct_nodes child ON parent.id = child.root_id AND child.id <> parent.choice2_id SET parent.choice1_id = child.id WHERE parent.id = ?");
            	pst2.setInt(1, node_id);
            	pst2.execute();
            }else if (nodeChoice == 2){
            	/*
            	 * Do the same thing as above but with choice 1 and 2 swapped
            	 */
            	PreparedStatement pst2 = conn.prepareStatement("UPDATE form.ct_nodes parent INNER JOIN form.ct_nodes child ON parent.id = child.root_id AND child.id <> parent.choice1_id SET parent.choice2_id = child.id WHERE parent.id = ?");
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
        String[] node = new String[9];
        
        //Variables for connecting to database
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";
        
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
  
            // Get all the useful informatio about the node
            pst = conn.prepareStatement("SELECT text, choice1_text, choice2_text, choice1_id, choice2_id, picture_string, numOfViews, isBlocked, user_id, votes FROM form.ct_nodes WHERE id = ?");
            pst.setInt(1, nodeid);
  
            rs = pst.executeQuery();
            rs.next();
            node[0] = rs.getString(1); //text
            node[1] = rs.getString(2); // choice1_text
            node[2] = rs.getString(3); // choice2_text
            node[3] = rs.getString(4); // choice1_id
            node[4] = rs.getString(5); // choice2_id
            node[5] = rs.getString(6); // picture_string
            
            int numOfViews = rs.getInt(7); // numOfViews
            if(rs.getInt(8) == 1){ // if the node is blocked
            	node[0] = "This Story has be blocked by an Admin.";
            	node[1] = node[0];
            	node[2] = node[1];
            	node[5] = "";
            }
            int temp = Integer.parseInt(rs.getString(9)); //user_id
            
            // Increase the number of views by one
            numOfViews += 1;
            node[6] = "" + numOfViews;
            node[8] = rs.getString(10); //votes
            pst.close();
            
            // update number of views
            pst = conn.prepareStatement("UPDATE form.ct_nodes SET numOfViews = ? WHERE id = ?");
            pst.setInt(1, numOfViews);
            pst.setInt(2, nodeid);
            pst.execute();
            pst.close();
            
            // get the node creators username from their userid
            pst = conn.prepareStatement("SELECT user FROM login WHERE id = ?");
            pst.setInt(1,temp);
            rs.close();
            rs = pst.executeQuery();
            rs.next();
            node[7] = rs.getString(1);
  
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
    
    /*
     * Update db with vote
     */
	public static void vote(String vote,int nodeid) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";
       
        try {  
        	do{
        		if(vote.equals("up") || vote.equals("down")){
 	            }else{
 	            	break;
 	            }
        		
	            Class.forName(driver).newInstance();  
	            conn = DriverManager.getConnection(url + dbName, userName, password);  
	  
	            /*
	             * Get current amount of votes
	             */
	            pst = conn.prepareStatement("SELECT votes FROM form.ct_nodes WHERE id = ?");
	            pst.setInt(1, nodeid);
	            rs = pst.executeQuery();
	            rs.next();
	            int votes = Integer.parseInt(rs.getString(1));
	            pst.close();
	            
	            /*
	             * Change amount of votes according to the vote method argument
	             * then update the database
	             */
	            if(vote.equals("up")){
 	            	votes++;
 	            }else{
 	            	votes--;
 	            }
	            System.out.println(votes);
	           
	            
	            pst = conn.prepareStatement("UPDATE form.ct_nodes SET votes = ? WHERE id = ?");
	            pst.setInt(1, votes);
	            pst.setInt(2, nodeid);
	            pst.execute();
            }while(false);
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
		
	}
	
	/*
	 * block the node
	 */
	public static void blockNode(int nodeid,boolean isBlocked) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        int isBlockedInt;
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";
       
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
            if(isBlocked == true){
            	isBlockedInt = 1;
            }else{
            	isBlockedInt = 0;
            }
            // set the node to blocked
            pst = conn.prepareStatement("UPDATE form.ct_nodes SET isBlocked = ? WHERE id = ?");
            pst.setInt(1, isBlockedInt);
            pst.setInt(2, nodeid);
            pst.execute();
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
		
	}
	/*
	 * Edit the node
	 */
	public static void editNode(String nodeid, String pText, String choice1, String choice2, String pictureText) {
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
  
            //update all the information about the node
            pst = conn.prepareStatement("UPDATE form.ct_nodes SET text=?,choice1_text=?,choice2_text=?,picture_string=? WHERE id=?");
            pst.setString(1, pText);  
            pst.setString(2, choice1);
            pst.setString(3, choice2);
            pst.setString(4, pictureText);
            pst.setInt(5, Integer.parseInt(nodeid));
  
            pst.execute();
  
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
	}
    
}  