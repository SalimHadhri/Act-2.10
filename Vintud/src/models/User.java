package models;

import interfaces.UserImpl;

public class User implements UserImpl {

	private int id ;
	private String firstname ;
	private String name ;
	private String pseudo  ;
	private String mail ;
	private String u_password  ;
	private String phone ;
	private String address  ;
	private int role_id  ;
	
	
	
	
	
	public User() {
	}





	public User(int id, String firstname, String name, String pseudo, String mail, String u_password, String phone,
			String address, int role_id) {
		this.id = id;
		this.firstname = firstname;
		this.name = name;
		this.pseudo = pseudo;
		this.mail = mail;
		this.u_password = u_password;
		this.phone = phone;
		this.address = address;
		this.role_id = role_id;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
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





	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", name=" + name + ", pseudo=" + pseudo + ", mail="
				+ mail + ", u_password=" + u_password + ", phone=" + phone + ", address=" + address + ", role_id="
				+ role_id + "]";
	}
	
	
	
	
	
}
