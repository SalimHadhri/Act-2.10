package DAO;

public interface AnnouncementDao {

	
	public void consulterAnnonces ()  ;
	public void findAnnounceById (int id) ;	
	public void findAnnouncementByNameCatgeryAndOrPrice () ;		
	public void filtreAnnoucementPrix () ;
	public void filtreAnnoucementLocalisation () ;
	public void voirNombreVues () ;

	
}
