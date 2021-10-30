package tests;


import dao.AnnouncementDao;
import dao.FavorisDAO;
import dao.RechercheDAO;
import dao.UserDao;
import daoImpl.AnnouncementDaoImpl;
import daoImpl.FavorisDaoImpl;
import daoImpl.RechercheDaoImpl;
import daoImpl.UserDaoImpl;
import models.User;
import utils.AnnouncementManager;

public class main {

	public static void main(String[] args) {

	
		/*******************************************************************/
		UserDao userdev = new UserDaoImpl() ;
		
		//userdev.creerUnCompte();
		//userdev.connectAccount() ;
		//userdev.modificationInformationsPersonnelles();
		
		/***********************************************************************/
		AnnouncementDao annoucementdev = new AnnouncementDaoImpl(); 
		
		//annoucementdev.consulterAnnonces(); 
		//annoucementdev.findAnnounceById (1) ;
		/********************************************************************/
		FavorisDAO favorisdev = new FavorisDaoImpl() ; 
		
		//favorisdev.creerFavoris(); 	
		//favorisdev.afficherFavoris();
		//favorisdev.supprimerFavoris();
		//favorisdev.RetrouverAnnounce();
		//favorisdev.modifyFavori(); 
		
		/******************************************************************************/
		RechercheDAO rechercheToUse = new  RechercheDaoImpl() ;
		
		rechercheToUse.creerRecherche(); 
		//rechercheToUse.afficherRecherches() ;
		//rechercheToUse.supprimerRecherche();
		//rechercheToUse.lancerRecherche();
		//rechercheToUse.modifyRecherche()   ;

	}

}
