package models;

import interfaces.RoleImpl;

public class Role implements RoleImpl {
	
	private int id ;
	private String nom ;
	
	
	public Role() {
	}


	public Role(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", nom=" + nom + "]";
	}
	
	
	

}
