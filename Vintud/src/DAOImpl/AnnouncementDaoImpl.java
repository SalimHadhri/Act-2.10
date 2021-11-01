package DAOImpl;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

import DAO.AnnouncementDao;
import DAO.CategoryDao;
import DAO.UserDao;
import factory.DAOFactory;
import models.Recherche;
import models.User;
import utils.ConnectionManager;

public class AnnouncementDaoImpl implements AnnouncementDao{

    Connection con = DAOFactory.connect();
    //ConnectionManager.getInstance().getConnection();

	CategoryDao categoryDao = DAOFactory.getCategoryDAO() ;
	UserDao userDAO = DAOFactory.getUserDAO() ;
	
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
	
	
	
	public void findAnnouncementByNameCatgeryAndOrPrice () {
		
		System.out.println("****Commencons notre recherche de l'annonce *****");
		
		System.out.println("  Entrez le nom de l'annonce ");
		Scanner sc1 = new Scanner(System.in);
		String nomAnnonce= sc1.nextLine();
		
		System.out.println("**********choisissez entre ces categories******");
		categoryDao.AfficherCategories();
		
		
		System.out.println("  Entrez la category de l'annonce ");
		Scanner sc2 = new Scanner(System.in);
		int categoriId= sc2.nextInt();
		
		System.out.println("  Entrez le prix de notre annonce  NB : O pour ne pas rechercher avec le prix");
		Scanner sc3 = new Scanner(System.in);
		String prixString = sc3.nextLine()  ;
    	Scanner scanner = new Scanner(prixString);
    	scanner.useLocale(Locale.US);
		float prixCategoryFoat= scanner.nextFloat() ;
		

		if(prixCategoryFoat !=0) {
			
		
		requete = "SELECT * FROM vintud.announcement WHERE title  ILIKE '%"+nomAnnonce+"%' "
				+ "AND category_id="+ categoriId +" AND price = "+ prixCategoryFoat  ;
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
				
	         boolean encore = r�sultats.next();
	         
	         if (encore) {
	        	 
	       
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
	         } else {
	        	 affiche("pas d'annonce correspondante !!");
	         }
			   
			  r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		affiche("fin du programme");
	    System.exit(0);  
		}else {

			requete = "SELECT * FROM vintud.announcement WHERE title ILIKE '%"+nomAnnonce+"%' "
					+ "AND category_id="+ categoriId  ;
			try {
		         Statement stmt = con.createStatement();
		         r�sultats = stmt.executeQuery(requete);
					
		         boolean encore = r�sultats.next();
		         
		         if (encore) {
		        	 
		       
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
		         } else {
		        	 affiche("pas d'annonce correspondante !!");
		         }
				   
				  r�sultats.close();
				} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requ�te") ;
				}
			affiche("fin du programme");
		    System.exit(0);  
		}
	}
	
	public void filtreAnnoucementPrix () {
		
		requete = "SELECT * FROM vintud.announcement  ORDER BY price ; ";
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
					+"\n"+"that's the price : "+r�sultats.getFloat("price")
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
	
	public void filtreAnnoucementLocalisation () {
		
		requete = "SELECT * FROM vintud.announcement  ORDER BY localisation ; ";
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
					+"\n"+"that's the localisation : "+r�sultats.getString("localisation")
					+"\n"+r�sultats.getInt("user_id") );
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
	}

	public void voirNombreVues () {
		
		User userConnected = userDAO.connectAccount() ;
		
		requete = "SELECT * FROM vintud.announcement WHERE user_id = "+userConnected.getId_user()+"; ";
		
		
		try {
	         Statement stmt = con.createStatement();
	         r�sultats = stmt.executeQuery(requete);
			 boolean encore = r�sultats.next();
			 while (encore) {
				 System.out.println("***********voici le nombre de vue pour chacune de vos annonces *************");
				   System.out.println("*********** new announcement ********");
				   System.out.println("id announcement : "+r�sultats.getInt("id")
					+"\n"+"title of your annoucement : " +  r�sultats.getString("title")
					+"\n" +" description of your annoucement : "  +r�sultats.getString("description")
					+"\n"+" number of view of your annoucement : " +r�sultats.getInt("view_number"));
				   
				   encore = r�sultats.next();
			   }
			   r�sultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requ�te") ;
			}
		
	}

    
}
