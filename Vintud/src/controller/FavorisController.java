package controller;

import java.util.List;

import DAO.FavorisDAO;
import factory.DAOFactory;
import models.Favoris;



public class FavorisController {

	
	FavorisDAO favorisDAO = DAOFactory.getFavorisDAO() ;
	
	public List<Favoris> getFavorisByUtilisateurId(int utilisateurId){
		return favorisDAO.findFavoriByIdUser(utilisateurId) ;
	}
		
		
		
	
}
