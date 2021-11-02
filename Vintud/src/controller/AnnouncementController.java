package controller;

import java.util.ArrayList;
import java.util.List; 

import DAO.AnnouncementDao;
import factory.DAOFactory;
import models.Announcement;

public class AnnouncementController {

	AnnouncementDao announcementDao = DAOFactory.getAnnoucementDAO() ;
	
	
	
	public AnnouncementController() {
	}

	public ArrayList<Announcement> getAnnoncesByUtilisateurId(int utilisateurId) {		
		return announcementDao.findAnnounceByIdUser(utilisateurId) ;	
	}
	
	public Announcement getAnnoncesById(int annonceId) {		
		return announcementDao.findAnnounceById(annonceId);	
	}
	

	public ArrayList<Announcement> getAllAnnonces() {		
		return announcementDao.findAllAnnoucement();	
	}
}
