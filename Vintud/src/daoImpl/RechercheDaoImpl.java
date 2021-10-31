package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import dao.AnnouncementDao;
import dao.RechercheDAO;
import dao.UserDao;
import models.Favoris;
import models.Recherche;
import models.User;
import utils.ConnectionManager;

public class RechercheDaoImpl implements RechercheDAO{
	
	
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
    
    
		
		
		
		public RechercheDaoImpl() {
		super();
	}

		public Recherche chooseRechercheSpecifications () {
			
	    	Recherche newRecherche = new Recherche() ;
	    	
	    	
	    	System.out.println(" Select your search specifications  :  ");
	    	
	    	System.out.println("**************************************");
	    	Scanner sc6 = new Scanner(System.in);
	    	System.out.println("Enter the id of your search :");
	    	int idFavori= sc6.nextInt();
	    	newRecherche.setId(idFavori);
		
		
	    	
	    	Scanner sc7 = new Scanner(System.in);
	    	System.out.println("Choose the type of the dress you're looking for :");
	    	String dress = sc7.nextLine() ;
	    	newRecherche.setType_habit(dress);
	    	
	    	
	    	Scanner sc8 = new Scanner(System.in);
	    	System.out.println("Select the size :");
	    	String size = sc8.nextLine() ;
	    	newRecherche.setTaille(size);
	    	
	    	Scanner sc9 = new Scanner(System.in);
	    	System.out.println("Choose one color :");
	    	String color = sc9.nextLine() ;
	    	newRecherche.setCouleur(color);
	    	
	    	Scanner sc10 = new Scanner(System.in); ;
	    	System.out.println("What's the maximum money you can afford ? :");
	    	String priceS = sc10.nextLine()  ;
	    	Scanner scanner = new Scanner(priceS);
	    	scanner.useLocale(Locale.US);
	    	float price = scanner.nextFloat() ;
	    	newRecherche.setFourchette_prix(price);
	    	
	    	
	    	UserDao userChoose = new UserDaoImpl();
	    	userChoose.afficherUtilisateurs(); 
			
	    	Scanner sc11 = new Scanner(System.in);
	    	System.out.println("Enter the id of the user performing this search :");
	    	int idUser= sc11.nextInt();
	    	newRecherche.setUser_id(idUser);
				
	    	return newRecherche;
	    }
		
		
	    public void creerRecherche () {
			
	    	Recherche rechercheChoisi = chooseRechercheSpecifications();	
	    	
	    	
	    	String typeHabit = "'"+rechercheChoisi.getType_habit()+"'" ;
	    	String taille = "'"+rechercheChoisi.getTaille()+"'" ;
	    	String couleur = "'"+rechercheChoisi.getCouleur()+"'" ;

	    	
	    	
	    	requete = "INSERT INTO vintud.recherche  values ("+rechercheChoisi.getId()+","+typeHabit+","+taille+","+couleur+","+rechercheChoisi.getFourchette_prix()+","+rechercheChoisi.getUser_id()+");"   ;
		
	    	try {
	    		Statement stmt = con.createStatement();
	    		stmt.executeUpdate(requete) ;
	        
	    		System.out.println("Your search has been saved !!   ");
	    		affiche("fin du programme");
	    		System.exit(0);
			} 
	    	catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}	
	}
	    
	    public void afficherRecherches() {
	    	
	    	requete = "SELECT * FROM vintud.recherche ; ";
			try {
		         Statement stmt = con.createStatement();
		         résultats = stmt.executeQuery(requete);
				 boolean encore = résultats.next();
				  while (encore) {
					   System.out.println("*********** new search ********");
					   System.out.println("id search : "+résultats.getInt("id")+"\n" +"type d'habit : "+  résultats.getString("type_habit") +"\n"+
							   "taille: "+  résultats.getString("taille") +"\n"+
							   "couleur: "+  résultats.getString("couleur") +"\n"+
							   "fourchette de prix: "+  résultats.getFloat("fourchette_prix")+"\n"+
							   "id user : "+résultats.getInt("user_id") );
					   
					   encore = résultats.next();
				   }
				   résultats.close();
				} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requête") ;
				}
	    }
	    
	    public void supprimerRecherche () {
	    	
	    	System.out.println("***Voici la liste des recherche: "+"\n"+" choisissez laquelle vous voulez supprimer *** ");
	    	afficherRecherches();
			
			Scanner sc7 = new Scanner(System.in);
			int idRechercheSupprimer= sc7.nextInt();
			
			try {
			requete ="DELETE FROM vintud.recherche WHERE id="+idRechercheSupprimer+" ;" ;
			
			
			PreparedStatement stmt = con.prepareStatement(requete);
			stmt.executeUpdate() ;

			System.out.println("Search deleted with success !!");
			stmt.close();
			
			System.out.println("Voici la nouvelle liste de favori");
			afficherRecherches();
			
	    	affiche("fin du programme");
		    System.exit(0);  
		} catch (SQLException e) {
			arret("Maybe you entered a false id !!");	}
	    	
	    }
	    
	    
	    public Recherche findResearchByIdUser (int id_user) {
	    		    	
	    	Recherche rechercheTrouvée = new Recherche() ;
			requete = "SELECT * FROM vintud.recherche WHERE user_id ="+id_user + "  ;" ;
			try {
		         Statement stmt = con.createStatement();
		         résultats = stmt.executeQuery(requete);
					
		         boolean encore = résultats.next();
				if(encore) {	
					rechercheTrouvée.setId(résultats.getInt("id"));
					rechercheTrouvée.setType_habit(résultats.getString("type_habit"));
					rechercheTrouvée.setTaille(résultats.getString("taille"));
					rechercheTrouvée.setCouleur(résultats.getString("couleur"));
					rechercheTrouvée.setFourchette_prix(résultats.getFloat("fourchette-prix"));				
					rechercheTrouvée.setUser_id(résultats.getInt("user_id"));		
				   	}
				   
				   résultats.close();
				   
			} catch (SQLException e) {
					arret("Anomalie lors de l'execution de la requête") ;
			}
			return rechercheTrouvée ;
	    }
	    
	    
	    
	    public void lancerRecherche() {
	    	
	    	UserDao daoUtilisateur = new UserDaoImpl () ;
	    	User utilisateurConnecte = daoUtilisateur.connectAccount() ;
	    	
	    	//Recherche searchFound = findResearchByIdUser(utilisateurConnecte.getId_user()) ;
	    	
	    	System.out.println("*********lancement de la recherche *********");
	    	
	    	Recherche rechercheLancé = new Recherche() ;
	    	rechercheLancé.setUser_id(utilisateurConnecte.getId_user());
	    	
	    	
	    	
	    	System.out.println(" Select your search specifications  :  ");
	    	
	    	System.out.println("**************************************");
	    	Scanner sc6 = new Scanner(System.in);
	    	System.out.println("Enter the id of your search :");
	    	int idFavori= sc6.nextInt();
	    	rechercheLancé.setId(idFavori);
		   	
	    	Scanner sc7 = new Scanner(System.in);
	    	System.out.println("Choose the type of the dress you're looking for :");
	    	String dress = sc7.nextLine() ;
	    	rechercheLancé.setType_habit(dress);
	    	
	    	
	    	Scanner sc8 = new Scanner(System.in);
	    	System.out.println("Select the size :");
	    	String size = sc8.nextLine() ;
	    	rechercheLancé.setTaille(size);
	    	
	    	Scanner sc9 = new Scanner(System.in);
	    	System.out.println("Choose one color :");
	    	String color = sc9.nextLine() ;
	    	rechercheLancé.setCouleur(color);
	    	
	    	
	    
	    	Scanner sc10 = new Scanner(System.in); ;
	    	System.out.println("What's the maximum money you can afford ? :");
	    	String priceS = sc10.nextLine()  ;
	    	Scanner scanner = new Scanner(priceS);
	    	scanner.useLocale(Locale.US);
	    	float price = scanner.nextFloat() ;
	    	rechercheLancé.setFourchette_prix(price);
	    	
	    	
	    	
	    	String typeHabit = "'"+rechercheLancé.getType_habit()+"'" ;
	    	String taille = "'"+rechercheLancé.getTaille()+"'" ;
	    	String couleur = "'"+rechercheLancé.getCouleur()+"'" ;

	    	
	    	
	    	requete = "INSERT INTO vintud.recherche  values ("+rechercheLancé.getId()+","+typeHabit+","+taille+","+couleur+","+rechercheLancé.getFourchette_prix()+","+rechercheLancé.getUser_id()+");"   ;
			
	    	try {
	    		Statement stmt = con.createStatement();
	    		stmt.executeUpdate(requete) ;
	        
	    		System.out.println("Your search has been lunched!!   ");
	    		affiche("fin du programme");
	    		System.exit(0);
			} 
	    	catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}	
	    	
	    	    	
	    }
	    
	    public void modifyRecherche() {
	 		 
			System.out.println("let's proceed to the modification ");		
			try { 
				
				System.out.println("that's the list of your searches");
				afficherRecherches() ;
				System.out.println("  now choose which search do you want to modify ");
				Scanner sc7 = new Scanner(System.in);
				int favoriToModify= sc7.nextInt();
				Recherche newSearch= chooseRechercheSpecifications () ;
				
				//float fourchette = newSearch.getFourchette_prix() ;
				//String fourchetteString ="" + fourchette;

				requete =" UPDATE  vintud.recherche  SET " 
    			 +"id= "+newSearch.getId()
    			 +",type_habit='" + newSearch.getType_habit()
    			 +"' ,taille= '" + newSearch.getTaille()
    			 +"',couleur = '" +newSearch.getCouleur() 
    			 +"',fourchette_prix = "+ newSearch.getFourchette_prix()
    			 +",user_id = " +newSearch.getUser_id()
    			 + " WHERE id="+  favoriToModify + ";" ; 
	
    		
				PreparedStatement stmt1 = con.prepareStatement(requete);
				stmt1.executeUpdate() ;
    		
				System.out.println("successs!! your search has been modified with success");
				stmt1.close();

			} 
			catch (SQLException e) {
			e.printStackTrace();
			}
	    	affiche("fin du programme");
		    System.exit(0) ;
    }	    
	
}


