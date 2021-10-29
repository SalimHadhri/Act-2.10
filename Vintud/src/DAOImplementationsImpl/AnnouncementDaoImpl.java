package DAOImplementationsImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.AnnouncementDao;
import DAO.UserDao;
import utils.ConnectionManager;

public class AnnouncementDaoImpl implements AnnouncementDao{

    Connection con = ConnectionManager.getInstance().getConnection();
    


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
    
 
	public AnnouncementDaoImpl() {
	}

	public void consulterAnnonces () {
		
		UserDao userdao = new UserDaoImpl();
		
    	requete = "SELECT * FROM vintud.announcement ; ";
		try {
	         Statement stmt = con.createStatement();
	         résultats = stmt.executeQuery(requete);
			 boolean encore = résultats.next();
			 while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(résultats.getInt("id")
					+"\n"+résultats.getString("title")
					+"\n"+résultats.getString("description")
					+"\n"+résultats.getInt("category_id")
					+"\n"+résultats.getFloat("price")
					+"\n"+résultats.getByte("picture")
					+"\n"+résultats.getTimestamp("publication_date")
					+"\n"+résultats.getBoolean("is_available")
					+"\n"+résultats.getInt("view_number")
					+"\n"+résultats.getString("localisation")
					+"\n"+résultats.getInt("user_id") );
				   
				   encore = résultats.next();
			   }
			   résultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
	}
	
	public void findAnnounceById (int id) {
		
		requete = "SELECT * FROM vintud.announcement WHERE id ='"+id+"'  ";
		try {
	         Statement stmt = con.createStatement();
	         résultats = stmt.executeQuery(requete);
				
	         boolean encore = résultats.next();
			  while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(résultats.getInt("id")
					+"\n"+résultats.getString("title")
					+"\n"+résultats.getString("description")
					+"\n"+résultats.getInt("category_id")
					+"\n"+résultats.getFloat("price")
					+"\n"+résultats.getByte("picture")
					+"\n"+résultats.getTimestamp("publication_date")
					+"\n"+résultats.getBoolean("is_available")
					+"\n"+résultats.getInt("view_number")
					+"\n"+résultats.getString("localisation")
					+"\n"+résultats.getInt("user_id") );
				   encore = résultats.next();
			   }
			   
			  résultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
	}
    
}
