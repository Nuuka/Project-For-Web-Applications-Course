package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;  


/*
 * This is not used anywhere
 */
public class ConnectUtil {
	Connection conn;
	
	static String url;  
    static String dbName;  
    static String driver;  
    static String userName;  
    static String password;
    
    public ConnectUtil(){
    	conn = null;
    	url = "jdbc:mysql://localhost:3306/";
    	dbName = "form";
    	driver = "com.mysql.jdbc.Driver";
    	userName = "root";
    	password = "webapp";
    }
    
    public void startConnection() throws Exception{
    	Class.forName(driver).newInstance();  
        conn = DriverManager.getConnection(url + dbName, userName, password);       	
    }
    
    public PreparedStatement prepareStatement(String sql) throws Exception{
    	return conn.prepareStatement(sql);
    }
    
    public void close(){
    	if (conn != null) {  
            try {  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }   
    }
}
