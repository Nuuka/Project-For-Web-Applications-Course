package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  

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
    public static boolean validate(String name, String pass) {          
        boolean status = true;  
        Connection conn = null; 
        
        PreparedStatement pst = null;  
        PreparedStatement validateUser = null;  
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

            //Checks the database for user with matching username
            validateUser = conn.prepareStatement("select * from login where user=?");
            validateUser.setString(1, name);  
            rs = validateUser.executeQuery();
            
            //If a username match was found the status will be set to false
            status = !rs.next(); 
            
            //If the status is true, adds the new user into the database.
            if(status){
	            pst = conn.prepareStatement("INSERT INTO `form`.`login` (`user`, `password`) VALUES (?, ?)"); 
	            pst.setString(1, name);  
	            pst.setString(2, pass);  
	            pst.execute();
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