package dao;

import models.Recherche;

public interface RechercheDAO {
	
	public Recherche chooseRechercheSpecifications ();
	public void creerRecherche () ;
	public void afficherRecherches() ;
	public void supprimerRecherche () ;
	public Recherche findResearchByIdUser (int id_user) ;
	public void lancerRecherche() ;
	public void modifyRecherche() ;
	
}
