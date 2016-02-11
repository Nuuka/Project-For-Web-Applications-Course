package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class NewNodeDao {  
    public static boolean validate(String text, String choice1, String choice2, String node_id, String choice1_id, String choice2_id) {          
        boolean status = true;  
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";  
        
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
  
            
            pst = conn.prepareStatement("INSERT INTO form.nodes (id, text, choice1_text, choice2_text, choice1_id, choice2_id) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setInt(1, Integer.parseInt(node_id));
            pst.setString(2, text);  
            pst.setString(3, choice1);
            pst.setString(4, choice2);
            pst.setInt(5, Integer.parseInt(choice1_id));
            pst.setInt(6, Integer.parseInt(choice2_id));
  
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
        return status;  
    }  
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
  
            
            pst = conn.prepareStatement("SELECT text, choice1_text, choice2_text, choice1_id, choice2_id FROM form.nodes WHERE id = ?");
            //pst.setString(1, ""+nodeid);
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