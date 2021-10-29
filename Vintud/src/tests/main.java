package tests;


import DAO.AnnouncementDao;
import DAO.FavorisDAO;
import DAO.UserDao;
import DAOImplementationsImpl.AnnouncementDaoImpl;
import DAOImplementationsImpl.FavorisDaoImpl;
import DAOImplementationsImpl.UserDaoImpl;
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
		favorisdev.modifyFavori(); 
		

	}

}
