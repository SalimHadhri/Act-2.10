package models;

import java.util.Date;

public class Favoris {
	
	private int id_favoris ;
	private int id_announcement ;
	private int id_utilisateur ;
	private String dateAjout ;
	
	
	
	public Favoris() {
	}
	

	public int getId_favoris() {
		return id_favoris;
	}


	public void setId_favoris(int id_favoris) {
		this.id_favoris = id_favoris;
	}



	public int getId_utilisateur() {
		return id_utilisateur;
	}


	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}


	public String getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(String dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Favoris(int id_favoris, int id_announcement, int id_utilisateur, String dateAjout) {
		this.id_favoris = id_favoris;
		this.id_announcement = id_announcement;
		this.id_utilisateur = id_utilisateur;
		this.dateAjout = dateAjout;
	}

	public int getId_announcement() {
		return id_announcement;
	}

	public void setId_announcement(int id_announcement) {
		this.id_announcement = id_announcement;
	}




	
	
	
	
	
	
	
	
	
	
	
	

}
