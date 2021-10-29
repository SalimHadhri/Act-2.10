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
    


    ResultSet r�sultats = null;
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
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			 while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(r�sultats.getInt("id")
					+"\n"+r�sultats.getString("title")
					+"\n"+r�sultats.getString("description")
					+"\n"+r�sultats.getInt("category_id")
					+"\n"+r�sultats.getFloat("price")
					+"\n"+r�sultats.getByte("picture")
					+"\n"+r�sultats.getTimestamp("publication_date")
					+"\n"+r�sultats.getBoolean("is_available")
					+"\n"+r�sultats.getInt("view_number")
					+"\n"+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
	}
	
	public void findAnnounceById (int id) {
		
		requete = "SELECT * FROM vintud.announcement WHERE id ='"+id+"'  ";
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         boolean encore = r�sultats.next();
			  while (encore) {
				   System.out.println("*********** new announcement ********");
				   System.out.println(r�sultats.getInt("id")
					+"\n"+r�sultats.getString("title")
					+"\n"+r�sultats.getString("description")
					+"\n"+r�sultats.getInt("category_id")
					+"\n"+r�sultats.getFloat("price")
					+"\n"+r�sultats.getByte("picture")
					+"\n"+r�sultats.getTimestamp("publication_date")
					+"\n"+r�sultats.getBoolean("is_available")
					+"\n"+r�sultats.getInt("view_number")
					+"\n"+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   encore = r�sultats.next();
			   }
			   
			  r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
	}
    
}
