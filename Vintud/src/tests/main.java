package tests;

import models.User;
import projectManagement.AnnouncementManager;
import projectManagement.ConnectionManager;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User userConnected = new User() ;
		AnnouncementManager announcementManager = new AnnouncementManager() ;
		//announcementManager.creerUnCompte() ;
		//announcementManager.connectAccount();
		//announcementManager.modificationInformationsPersonnelles(); 
		announcementManager.consulterAnnonces();
	}

}
