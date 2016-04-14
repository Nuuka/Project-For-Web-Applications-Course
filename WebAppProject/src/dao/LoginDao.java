package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

import bCrypt.BCrypt;  
 
/**
 * This class is used to connect to the database and verify login info.
 * 
 * @author Joey MacLean
 * @version 1.0
 */
public class LoginDao {
	/**
	 * Connects to the database and validates the login information.
	 * 
	 * @version 1.0
	 * @param name The username to validate
	 * @param pass The password linked to the username
	 * @return True if the username and password was found, otherwise false
	 */
    public static int validate(String name, String pass) {          
        
    	int id = 0;
        
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        
        //Variables for connecting to database
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp"; 
        String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
            
            //The statement to be executed, searches for entries matching both the username and password
            pst = conn.prepareStatement("select * from login where user=? and password=?");
            pst.setString(1, name);  
            pst.setString(2, pass);  
  
            //Executes the statement and returns a result set
            rs = pst.executeQuery();  
            //next() will return false if there is no results and true if there are.
            if(rs.next()){
            	id = rs.getInt(1);
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
        return id;  
    }  
    
    public static String[] getAccountInfo(int id) {          
        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        String[] info = new String[5];
        
        
        //Variables for connecting to database
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp"; 
        
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
            
            //The statement to be executed, searches for entries matching both the username and password
            pst = conn.prepareStatement("select * from login where id=?");
            pst.setLong(1, id);   
  
            //Executes the statement and returns a result set
            rs = pst.executeQuery();  
            //next() will return false if there is no results and true if there are.
            if(rs.next()){
            	info[0] = rs.getString(4); // First Name
            	info[1] = rs.getString(5); // Last Name
            	info[2] = rs.getString(6); // Email
            	info[3] = rs.getString(7); // Account Type
            	info[4] = rs.getString(8); // Picture String
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
        return info;  
    }  
    
}  