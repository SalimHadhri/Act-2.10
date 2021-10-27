package projectManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class AnnouncementManager {

	
	Connection  con = ConnectionManager.getConnection();
    ResultSet résultats = null;
    String requete = "";
    ResultSetMetaData rsmd;
	
    private static void arret(String message) {
        System.err.println(message);
        System.exit(99);
     }
    
    private static void affiche(String message) {
        System.out.println(message);
     }
    
    
    
    
}
