package utils;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


	
	

public class ConnectionManager {

	private static ConnectionManager connectionManager ;
    private static Connection con ;
    private static Statement stmt;
    
    private ConnectionManager() {
      // private constructor //
    }

    public static ConnectionManager getInstance(){
    if(connectionManager==null){
    	connectionManager= new ConnectionManager();
    }
    return connectionManager;
    }

    public  Connection getConnection() {
    	
             try {
				Class.forName("org.postgresql.Driver");
			
             if(con==null){
            	 try {
            		 
            		 con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/vintud", "postgres", "DkPB7D+");
            	 }
            	 catch (SQLException ex) {
            		 System.out.println("Failed to create the database connection.");
            	 }
            	 
            	}
             } catch (ClassNotFoundException e) {
 				// TODO Auto-generated catch block
                 System.out.println("Driver not found."); 			}


        return con;
    }
    
}