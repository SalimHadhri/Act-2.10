package controller;

import java.util.ArrayList;
import java.util.List;

import DAO.AnnouncementDao;
import DAO.UserDao;
import factory.DAOFactory;
import models.Announcement;
import models.User;

public class UserController {
	
	UserDao userDAO = DAOFactory.getUserDAO() ;
	
	public UserController() {
	}
	
	public ArrayList<User> getAllUsers() {		
		return userDAO.findAllUsers();	
	}
	
	
	

}
