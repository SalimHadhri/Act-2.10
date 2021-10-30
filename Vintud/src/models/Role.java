package models;

import java.util.List;

import dao.RoleDao;

public class Role  {
	
	private int role_id ;
	private String nom ;
	
	public Role() {
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}



	public Role(int role_id, String nom) {
		super();
		this.role_id = role_id;
		this.nom = nom;
	}

}
