package DAO;

import java.util.ArrayList;
import java.util.List;

import models.User;

public interface UserDao {
		
	public void creerUnCompte () ;	
	public User chooseUserSpecifications ();	
	public void afficherRoles() ;
	public User connectAccount () ; 
	public void modificationInformationsPersonnelles () ;
	public void afficherUtilisateurs() ;
	
	public ArrayList<User> findAllUsers () ;

	
}
