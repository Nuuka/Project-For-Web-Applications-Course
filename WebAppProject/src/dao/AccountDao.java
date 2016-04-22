package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
	public static void updatePhoto(String id, String pictureText){ 
	    Connection conn = null;  
	    PreparedStatement pst = null;  
	    ResultSet rs = null;  
	    
	    //Variables for connecting to database
	    String url = "jdbc:mysql://localhost:3306/";  
	    String dbName = "form";  
	    String driver = "com.mysql.jdbc.Driver";  
	    String userName = "root";  
	    String password = "webapp";  
	    
	    try {  // try to connect
	        Class.forName(driver).newInstance();  
	        conn = DriverManager.getConnection(url + dbName, userName, password);  
	        
	        //update picture
        	PreparedStatement pst2 = conn.prepareStatement("UPDATE form.login SET accountPicture=? WHERE id=?");
        	
        	pst2.setString(2,id); // ID of user account
        	pst2.setString(1,pictureText); // Text of the picture
        	pst2.execute();

	
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
