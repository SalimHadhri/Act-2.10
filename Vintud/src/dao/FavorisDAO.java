package dao;

import java.text.ParseException;

import models.Favoris;
import models.User;

public interface FavorisDAO {

	public void creerFavoris () ;
	public Favoris chooseFavorisSpecifications ()  ;
	public void afficherFavoris() ;
	public void supprimerFavoris () ;
	public void RetrouverAnnounce() ;
	public Favoris findFavoriById (int id) ;
	public void modifyFavori()	;
}
