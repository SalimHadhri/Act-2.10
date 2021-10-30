package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;

public class User {

	private int id_user ;
	private String firstname ;
	private String name ;
	private String pseudo  ;
	private String mail ;
	private String u_password  ;
	private String phone ;
	private String address  ;
	
	
	private int role_id  ;
	
	private List<Announcement> annonces    ;	
	private List<Announcement> ListAnnonceFavoris;
	
	
	public User() {
	}





	public User(int id_user, String firstname, String name, String pseudo, String mail, String u_password, String phone,
			String address, int role_id) {
		this.id_user = id_user;
		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.u_password = u_password;
		this.phone = phone;
		this.address = address;
		this.role_id = role_id;
	}


	public User(int id_user, String firstname, String name, String pseudo, String mail, String u_password, String phone,
			String address, int role_id, List<Announcement> annonces, List<Announcement> listAnnonceFavoris) {
		this.id_user = id_user;
		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.u_password = u_password;
		this.phone = phone;
		this.address = address;
		this.role_id = role_id;
		this.annonces = annonces;
		ListAnnonceFavoris = listAnnonceFavoris;
	}



	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}



	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getU_password() {
		return u_password;
	}


	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}



	public List<Announcement> getAnnonces() {
		return annonces;
	}


	public void setAnnonces(List<Announcement> annonces) {
		this.annonces = annonces;
	}



	public List<Announcement> getListAnnonceFavoris() {
		return ListAnnonceFavoris;
	}


	public void setListAnnonceFavoris(List<Announcement> listAnnonceFavoris) {
		ListAnnonceFavoris = listAnnonceFavoris;
	}
	
	
}
