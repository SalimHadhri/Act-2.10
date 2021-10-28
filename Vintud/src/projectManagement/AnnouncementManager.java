package projectManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

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
		user.setPhone(phoneNumber);
		 
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
      
    public User connectAccount () {
    	
    	User userConnected = new User () ;
		boolean repeat = true ;		
	 	while (repeat ) {
		
			
		try {

				
				Scanner sc21 = new Scanner(System.in);
				System.out.println("Enter your email:");
				String email= sc21.nextLine() ;


				Scanner sc23 = new Scanner(System.in);
				System.out.println("Enter your password:");
				String passeword= sc23.nextLine();
       
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

					  userConnected.setId_user(résultats.getInt("id"));
					  userConnected.setFirstname(résultats.getString("firstname"));
					  userConnected.setName(résultats.getString("name"));
					  userConnected.setPseudo(résultats.getString("pseudo"));
					  userConnected.setMail(résultats.getString("mail"));
					  userConnected.setU_password(résultats.getString("u_password"));
					  userConnected.setPhone(résultats.getString("phone"));
					  userConnected.setAddress(résultats.getString("address"));
					  userConnected.setRole_id(résultats.getInt("role_id"));

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

	 	return userConnected ;
	 	
	    //System.exit(0);
	    
	    //return userConnected ;
	    
	}

    public void modificationInformationsPersonnelles () {
    	
    	User connectedUser = connectAccount(); 
    	
    	System.out.println("  let's modify your personal infos ");
    	
    	System.out.println("pleaze enter your new informations");
    	
    	User newUserSpecifications = chooseUserSpecifications() ;
    	
    	try {
    		
    	
    		String firstname = "'"+newUserSpecifications.getFirstname()+"'" ;
    		String name = "'"+newUserSpecifications.getName()+"'" ;
    		String pseudo = "'"+newUserSpecifications.getPseudo()+"'" ;
    		String email = "'"+newUserSpecifications.getMail()+"'" ;
    		String pwd = "'"+newUserSpecifications.getU_password()+"'" ;
    		String phoneNumber = "'"+newUserSpecifications.getPhone()+"'" ;
    		String address = "'"+newUserSpecifications.getAddress()+"'" ;
		
		
    		String Mail2 = "'"+connectedUser.getMail()+"'" ;
    		String pwd2 = "'"+connectedUser.getU_password()+"'" ;

    		requete =" UPDATE vintud.user SET " + 
    			 "id= "+newUserSpecifications.getId_user()+
    			 ",firstname="+firstname+
    			 ",name="+name+
    			 ",pseudo="+pseudo+
    			 ",mail="+email+
    			 ",u_password="+pwd+
    			 ",phone="+phoneNumber+
    			 ",address="+address+
    			 ",role_id="+newUserSpecifications.getRole_id()+
    			 " WHERE mail = "+Mail2+" AND  u_password="+pwd2 +"  ; " ; 
    			
    		
    		PreparedStatement stmt = con.prepareStatement(requete);
    		stmt.executeUpdate() ;
    		
			System.out.println("successs!! your personal credentials has been modified with success");
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	affiche("fin du programme");
	    System.exit(0);  	
    }

}

    

    
    

