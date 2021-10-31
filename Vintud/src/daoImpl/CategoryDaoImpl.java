package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import dao.CategoryDao;
import utils.ConnectionManager;

public class CategoryDaoImpl implements CategoryDao{

	
	

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
    
    
	public CategoryDaoImpl() {
	}

	public void AfficherCategories () {
		
    	requete = "SELECT * FROM vintud.category ; ";
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
				 boolean encore = r�sultats.next();
				  while (encore) {
					   System.out.println("*********** new category ********");
					   System.out.println("id category : "+r�sultats.getInt("id")+"\n" +"name category : "+  r�sultats.getString("name") +"\n"+
							   "description : "+  r�sultats.getString("description")  );
					   
					   encore = r�sultats.next();
				   }
				   r�sultats.close();
				} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
				}
	    }
	

}
