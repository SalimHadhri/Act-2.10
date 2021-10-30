package daoImpl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.AnnouncementDao;
import dao.FavorisDAO;
import dao.UserDao;
import models.Favoris;
import models.User;
import utils.ConnectionManager;

public class FavorisDaoImpl implements FavorisDAO{

	
	 	Connection con = ConnectionManager.getInstance().getConnection();

	    ResultSet résultats = null;
	    String requete = "";
	    ResultSetMetaData rsmd;
	    

		public FavorisDaoImpl() {
		}

		private static void arret(String message) {
	        System.err.println(message);
	        System.exit(99);
	     }
	    
	    private static void affiche(String message) {
	        System.out.println(message);
	     }
	    
	
	    public Favoris chooseFavorisSpecifications () {
		
	    	Favoris favoris = new Favoris() ;  	
	    	System.out.println(" Select your favoris :  ");
	    	Scanner sc6 = new Scanner(System.in);
	    	System.out.println("Enter the id of your favori :");
	    	int idFavori= sc6.nextInt();
	    	favoris.setId_favoris(idFavori);
		
		
	    	UserDao userChoose = new UserDaoImpl();
	    	userChoose.afficherUtilisateurs(); 
			
	    	Scanner sc7 = new Scanner(System.in);
	    	System.out.println("Enter the id of your user :");
	    	int idUser= sc7.nextInt();
	    	favoris.setId_utilisateur(idUser);
		
	    	AnnouncementDao annonceChoose = new AnnouncementDaoImpl();
	    	annonceChoose.consulterAnnonces(); 
	    	Scanner sc8 = new Scanner(System.in);
	    	System.out.println("Enter the id of your announcement :");
	    	int idAnnouncement= sc8.nextInt();
	    	favoris.setId_announcement(idAnnouncement);
		
		
	    	Scanner sc9 = new Scanner(System.in);
	    	System.out.println("Enter the  date of you favori creation   sous format yyyy-MM-dd:");
	    	String datecreation= sc9.nextLine() ;
	    	favoris.setDateAjout(datecreation);
		
	    	return favoris;
	    }
	
	
	
	    public void creerFavoris () {
		
	    	Favoris favoris = chooseFavorisSpecifications () ;	
	    	String dateRequete = "'"+favoris.getDateAjout()+"'" ;
	    	requete = "INSERT INTO vintud.favoris  values ("+favoris.getId_favoris()+","+favoris.getId_announcement()+","+favoris.getId_utilisateur()+','+dateRequete+");"   ;
		
	    	try {
	    		Statement stmt = con.createStatement();
	    		stmt.executeUpdate(requete) ;
	        
	    		System.out.println("Your favoris has been saved !! Congrat ;)  ");
	    		affiche("fin du programme");
	    		System.exit(0);
			} 
	    	catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}	
	}
		
	public void afficherFavoris() {				

		requete = "SELECT * FROM vintud.favoris ; ";
		try {
	         Statement stmt = con.createStatement();
	         résultats = stmt.executeQuery(requete);
			 boolean encore = résultats.next();
			  while (encore) {
				   System.out.println("*********** new Favori ********");
				   DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				   System.out.println(résultats.getInt("id")+"\n"+dateFormat.format(résultats.getDate("dateajout"))+"\n" +"id announcement :  "+  résultats.getInt("announcement_id")
				   +"\n" +résultats.getInt("user_id")); 
				   
				   encore = résultats.next();
			   }
			   résultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
	}
	
	
	public void supprimerFavoris () {
		
		System.out.println("Voici la liste des favoris: "+"\n"+" choisissez lequel vous voulez supprimer :( ");
		afficherFavoris();
		
		Scanner sc7 = new Scanner(System.in);
		int idFavoriToDelete= sc7.nextInt();
		
		try {
		requete ="DELETE FROM vintud.favoris WHERE id="+idFavoriToDelete+" ;" ;
		
		
		PreparedStatement stmt = con.prepareStatement(requete);
		stmt.executeUpdate() ;

		System.out.println("Favori deleted with success !!");
		stmt.close();
		
		System.out.println("Voici la nouvelle liste de favori");
		afficherFavoris();
		
    	affiche("fin du programme");
	    System.exit(0);  
	} catch (SQLException e) {
		arret("Maybe you entered a false id !!");	}
		
	}
	
		
	public void RetrouverAnnounce() {
		
		AnnouncementDao annouceToFind= new AnnouncementDaoImpl () ; 
		System.out.println("For which favori do you want to find the annoucement ? Choose one !!");	
		afficherFavoris() ;		
		Scanner sc7 = new Scanner(System.in);
		int announceToFind= sc7.nextInt();	
		System.out.println(" That's it !! look at your dashbord ");	
		annouceToFind.findAnnounceById(announceToFind);

	}

	public Favoris findFavoriById (int id) {
		
		Favoris favoriFound = new Favoris() ;
		requete = "SELECT * FROM vintud.favoris WHERE id ="+id + "  ;" ;
		try {
	         Statement stmt = con.createStatement();
	         résultats = stmt.executeQuery(requete);
				
	         boolean encore = résultats.next();
			if(encore) {				
				favoriFound.setId_announcement(résultats.getInt("announcement_id"));
				favoriFound.setId_favoris(résultats.getInt("id"));
				favoriFound.setId_utilisateur(résultats.getInt("user_id"));
			 
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		 
				String dateToBe = dateFormat.format(résultats.getDate("dateajout"))  ;
		 
				String date = dateFormat.format(résultats.getDate("dateajout")) ;
				favoriFound.setDateAjout(dateToBe);
			   	}
			   
			   résultats.close();
			   
		} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
		}
		return favoriFound ;
	}


	public void modifyFavori() {
	 		 
				System.out.println("let's proceed to the modification ");		
				try { 
					
					System.out.println("that's the list of your favori");
					afficherFavoris() ;
					System.out.println("  now choose which favori do you want to modify ");
					Scanner sc7 = new Scanner(System.in);
					int favoriToModify= sc7.nextInt();
					Favoris newFavorie = chooseFavorisSpecifications () ;			 

					String date = "'"+ newFavorie.getDateAjout()+"'" ;
					requete =" UPDATE  vintud.favoris  SET " 
	    			 +"id= "+newFavorie.getId_favoris()
	    			 +",announcement_id=" + newFavorie.getId_announcement()
	    			 +",user_id=" + newFavorie.getId_utilisateur()
	    			 +",dateajout= " +date 
	    			 + " WHERE id="+  favoriToModify + ";" ; 
    	
	    		
					PreparedStatement stmt1 = con.prepareStatement(requete);
					stmt1.executeUpdate() ;
	    		
					System.out.println("successs!! your personal credentials has been modified with success");
					stmt1.close();

				} 
				catch (SQLException e) {
				e.printStackTrace();
				}
		    	affiche("fin du programme");
			    System.exit(0) ;
	    }
		
		
		
		
	 		
		}
	
	

