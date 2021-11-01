package tests;



import DAO.AnnouncementDao;
import DAO.CategoryDao;
import DAO.FavorisDAO;
import DAO.RechercheDAO;
import DAO.UserDao;
import factory.DAOFactory;
import models.User;

public class main {

	public static void main(String[] args) {

		UserDao userDao = DAOFactory.getUserDAO();
		AnnouncementDao announcementDao = DAOFactory.getAnnoucementDAO() ;
		FavorisDAO favorisDAO = DAOFactory.getFavorisDAO();
		RechercheDAO rechercheDAO = DAOFactory.getRechercheDAO() ;
		CategoryDao categoryDao = DAOFactory.getCategoryDAO() ; 
		
		
		
		
		/*******************************************************************/
		
		//userDao.creerUnCompte();
		//userDao.connectAccount() ;
		//userDao.modificationInformationsPersonnelles();
		
		/***********************************************************************/
		
		//announcementDao.consulterAnnonces(); 
		//announcementDao.findAnnounceById (1) ;
		/********************************************************************/
		
		//favorisDAO.creerFavoris(); 	
		//favorisDAO.afficherFavoris();
		//favorisDAO.supprimerFavoris();
		//favorisDAO.RetrouverAnnounce();
		//favorisDAO.modifyFavori(); 
		
		/******************************************************************************/
		
		//rechercheDAO.creerRecherche(); 
		//rechercheDAO.afficherRecherches() ;
		//rechercheDAO.supprimerRecherche();
		//rechercheDAO.lancerRecherche();
		//rechercheDAO.modifyRecherche()   ;

		/*********************************************************************************/
		
		//categoryDao.AfficherCategories();
		
		/***************************************************************/
		
		//announcementDao.consulterAnnonces(); 
		//announcementDao.findAnnouncementByNameCatgeryAndOrPrice();
		//announcementDao.filtreAnnoucementPrix();
		//announcementDao.filtreAnnoucementLocalisation();
		
		/****************************************************************/
		//favorisDAO.enregistrerAnnonceFavori(90) ;
		
		/***************************************************************/
		//announcementDao.voirNombreVues(); 
	}

}
