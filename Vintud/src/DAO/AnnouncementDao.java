package DAO;

import java.util.ArrayList;
import java.util.List;

import models.Announcement;

public interface AnnouncementDao {

	
	public void consulterAnnonces ()  ;
	public void findAnnouncementByNameCatgeryAndOrPrice () ;		
	public void filtreAnnoucementPrix () ;
	public void filtreAnnoucementLocalisation () ;
	public void voirNombreVues () ;
	
	public ArrayList<Announcement> findAnnounceByIdUser(int id);
	public Announcement findAnnounceById (int id) ;	
	public ArrayList<Announcement> findAllAnnoucement();

	
}
