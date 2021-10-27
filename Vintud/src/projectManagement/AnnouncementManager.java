package projectManagement;

import java.sql.Connection;  
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import models.User;

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
    
    
    
    public AnnouncementManager() {
		super();
	}

	public void creerUnCompte (){

    	
		User user = chooseUserSpecifications() ;
		
		String firstname = "'"+user.getFirstname()+"'" ;
		String name = "'"+user.getName()+"'" ;
		String pseudo = "'"+user.getPseudo()+"'" ;
		String email = "'"+user.getMail()+"'" ;
		String pwd = "'"+user.getU_password()+"'" ;
		String phoneNumber = "'"+user.getPhone()+"'" ;
		String address = "'"+user.getAddress()+"'" ;
		
	
		requete = "INSERT INTO vintud.user  values ("+user.getId_user()+","+firstname+","+name+","+pseudo+","+email+","+pwd+","+phoneNumber+","+address+","+user.getRole_id()+");"   ;
		
		
		try {
	         Statement stmt = con.createStatement();
	         stmt.executeUpdate(requete) ;
	        
	         System.out.println("Your profile has been saved !! Congrat ;)  ");
	         résultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
		affiche("fin du programme");
	    System.exit(0);
	}
    
	
    
    public User chooseUserSpecifications () {
		
    	User user = new User() ;
    	
    	System.out.println(" Select your profile credentials :  ");

		Scanner sc6 = new Scanner(System.in);
		System.out.println("Enter the id of your profile:");
		int idUser= sc6.nextInt();
		user.setId_user(idUser);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your firstname :");
		String firstname = sc.nextLine();
		user.setFirstname(firstname);
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter your name :");
		String name = sc1.nextLine();
		user.setName(name);
		
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Please enter your pseudo  :");
		String pseudo = sc3.nextLine();
		user.setPseudo(pseudo);
		
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Please enter your email :");
		String email = sc4.nextLine();
		user.setMail(email);
		
		Scanner sc10 = new Scanner(System.in);
		System.out.println("Please enter your password :");
		String password = sc10.nextLine();
		user.setU_password(password);
		
		Scanner sc11 = new Scanner(System.in);
		System.out.println("Please enter your phone number :");
		String phoneNumber = sc11.nextLine();
		user.setU_password(phoneNumber);
		 
		Scanner sc12 = new Scanner(System.in);
		System.out.println("Please enter your address:");
		String address = sc12.nextLine();
		user.setAddress(address);
		
		afficherRoles() ;
		
		Scanner sc14 = new Scanner(System.in);
		System.out.println("Enter the id of your role:");
		int idRole= sc14.nextInt();
		user.setRole_id(idRole);
		
		
		
		return user;
	}
    
    
    public void afficherRoles() {				

		requete = "SELECT * FROM vintud.role ; ";
		try {
	         Statement stmt = con.createStatement();
	         résultats = stmt.executeQuery(requete);
			 boolean encore = résultats.next();
			   while (encore) {
				   System.out.println("*********** new library ********");
				   System.out.println(résultats.getInt("id")+"\n"+résultats.getString("nom")); 
				   
				   encore = résultats.next();
			   }
			   résultats.close();
			} catch (SQLException e) {
				arret("Anomalie lors de l'execution de la requête") ;
			}
	}
      
    public void connectAccount () {
    	

		boolean repeat = true ;		
	 	while (repeat ) {
		
			
		try {

				
				Scanner sc14 = new Scanner(System.in);
				System.out.println("Enter your email:");
				String email= sc14.nextLine() ;


				Scanner sc15 = new Scanner(System.in);
				System.out.println("Enter your password:");
				String passeword= sc15.nextLine();
       
				String Mail2 = "'"+email+"'" ;
				String pwd2 = "'"+passeword+"'" ;
	         
				requete = "SELECT * FROM vintud.user WHERE mail = "+Mail2+" AND  u_password="+pwd2 +"  ; ";

				Statement stmt = con.createStatement();
				résultats = stmt.executeQuery(requete);
				boolean encore = résultats.next(); 
			 
					if(encore) 
					{
					  System.out.println("successs");
					  repeat = false ;

					  
					}
					else {
					  System.out.println("failed!!  enter new passeword!!");

					}
	  			  	résultats.close();
			   
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 	
		affiche("fin du programme");
	    System.exit(0);
	}
	 	

}

    	
    

    
    

