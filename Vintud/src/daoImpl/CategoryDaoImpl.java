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
    
    
	public CategoryDaoImpl() {
	}

	public void AfficherCategories () {
		
    	requete = "SELECT * FROM vintud.category ; ";
			try {
		         Statement stmt = con.createStatement();
		         résultats = stmt.executeQuery(requete);
				 boolean encore = résultats.next();
				  while (encore) {
					   System.out.println("*********** new category ********");
					   System.out.println("id category : "+résultats.getInt("id")+"\n" +"name category : "+  résultats.getString("name") +"\n"+
							   "description : "+  résultats.getString("description")  );
					   
					   encore = résultats.next();
				   }
				   résultats.close();
				} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requête") ;
				}
	    }
	

}
