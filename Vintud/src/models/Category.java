package models;

import java.util.List;

import interfaces.CategoryImpl;

public class Category implements CategoryImpl{

	
	private int id_category ;
	private String name  ;
	private String description  ;
	private List<Announcement> annoucementsList    ;
	
	public Category() {
	}




	public int getId_category() {
		return id_category;
	}




	public void setId_category(int id_category) {
		this.id_category = id_category;
	}




	public Category(int id_category, String name, String description) {
		this.id_category = id_category;
		this.name = name;
		this.description = description;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}




	public List<Announcement> getAnnoucementsList() {
		return annoucementsList;
	}


	public void setAnnoucementsList(List<Announcement> annoucementsList) {
		this.annoucementsList = annoucementsList;
	}
	
	
	
	
}
