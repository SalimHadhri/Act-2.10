package tests;


import dao.AnnouncementDao;

import dao.CategoryDao;
import dao.FavorisDAO;
import dao.RechercheDAO;
import dao.UserDao;
import daoImpl.AnnouncementDaoImpl;
import daoImpl.CategoryDaoImpl;
import daoImpl.FavorisDaoImpl;
import daoImpl.RechercheDaoImpl;
import daoImpl.UserDaoImpl;
import models.User;

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
		
		//rechercheToUse.creerRecherche(); 
		//rechercheToUse.afficherRecherches() ;
		//rechercheToUse.supprimerRecherche();
		//rechercheToUse.lancerRecherche();
		//rechercheToUse.modifyRecherche()   ;

		/*********************************************************************************/
		CategoryDao categoryDaoToUse = new CategoryDaoImpl() ;
		
		//categoryDaoToUse.AfficherCategories();
		
		/***************************************************************/
		
		//annoucementdev.consulterAnnonces(); 
		//annoucementdev.findAnnouncementByNameCatgeryAndOrPrice();
		//annoucementdev.filtreAnnoucementPrix();
		annoucementdev.filtreAnnoucementLocalisation();
	}

}
