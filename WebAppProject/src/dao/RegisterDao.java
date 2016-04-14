package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

import bCrypt.BCrypt;  

/**
 * This class is used to connect to the database and add a new user.
 * 
 * @author Joey MacLean, Mohamed Ashour
 * @version 1.0
 */
public class RegisterDao { 
	/**
	 * Connects to the database and adds the new user info into the database.
	 * 
	 * @version 1.0
	 * @param name The username of the new user
	 * @param pass The password linked to the username
	 * @return True if the user was registers successfully , false if a user with that name already exists 
	 */
    public static boolean createAccount(String name, String pass, String firstName, String lastName, String email) {          
        boolean status = true;  
        Connection conn = null; 
        
        PreparedStatement pst = null;  
        PreparedStatement validateUser = null;  
        ResultSet rs = null;  
  
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "form";  
        String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "webapp";  
        String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  

            //Checks the database for user with matching username
            validateUser = conn.prepareStatement("select * from login where user=?");
            validateUser.setString(1, name);  
            rs = validateUser.executeQuery();
            
            //If a username match was found the status will be set to false
            status = !rs.next(); 
            
            //If the status is true, adds the new user into the database.
            if(status){
            	pst = conn.prepareStatement("INSERT INTO `form`.`login` (`user`, `password`,`firstName`,`lastName`,`email`,`accountType`) VALUES (?, ?, ?, ?, ?, \"basic\")"); 
	
	            pst.setString(1, name);  
	            pst.setString(2, pass);
	            pst.setString(3, firstName);  
	            pst.setString(4, lastName);  
	            pst.setString(5, email);  
	            //pst.setString(6, "basic");
 	           //pst = conn.prepareStatement("INSERT INTO `form`.`login` (`user`, `password`,`firstName`,`lastName`,`email`,`accountType`) VALUES (test3, test3, test3, test3, test3, test3)"); 

	            pst.execute();
	            //rs = pst.executeQuery();  
	            //status = rs.next(); 
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
    
    
}  