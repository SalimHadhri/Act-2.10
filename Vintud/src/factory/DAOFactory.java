package factory;

import java.sql.Connection;

import DAO.AnnouncementDao;
import DAO.CategoryDao;
import DAO.FavorisDAO;
import DAO.RechercheDAO;
import DAO.RoleDao;
import DAO.UserDao;
import DAOImpl.AnnouncementDaoImpl;
import DAOImpl.CategoryDaoImpl;
import DAOImpl.FavorisDaoImpl;
import DAOImpl.RechercheDaoImpl;
import DAOImpl.RoleDaoImpl;
import DAOImpl.UserDaoImpl;
import utils.ConnectionManager;

public class DAOFactory {
	
	
	
	public static AnnouncementDao getAnnoucementDAO(){
        return new AnnouncementDaoImpl();
    }
	
	public static CategoryDao getCategoryDAO(){
        return new CategoryDaoImpl();
    }	
	public static FavorisDAO getFavorisDAO(){
        return new FavorisDaoImpl();
    }	
	public static RechercheDAO getRechercheDAO(){
        return new RechercheDaoImpl();
    }	
	public static RoleDao getRoleDAO(){
        return new RoleDaoImpl();
    }	
	public static UserDao getUserDAO(){
        return new UserDaoImpl();
    }
	
  
	public static Connection connect () {
		return ConnectionManager.getInstance().getConnection() ;
	}

}
