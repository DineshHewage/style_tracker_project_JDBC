/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Dinesh
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        
        String url = "jdbc:mysql://localhost:3306/styletracker";
        String username = "root";
        String password = "Dinesh@12345";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public static DBConnection getDBConnection()throws ClassNotFoundException, SQLException{
        if(dbConnection==null){
           dbConnection = new DBConnection();
        }
        return dbConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
