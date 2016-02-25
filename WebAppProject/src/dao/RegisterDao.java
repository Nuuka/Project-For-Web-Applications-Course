package dao;  
  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class RegisterDao {  
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
        try {  
            Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url + dbName, userName, password);  
  


            validateUser = conn.prepareStatement("select * from login where user=?");
            validateUser.setString(1, name);  
            rs = validateUser.executeQuery();
            status = !rs.next(); 

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