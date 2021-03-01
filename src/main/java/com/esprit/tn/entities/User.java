package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idUser;	
	@Column(name= "Name")
	private String Name;
	@Column(name= "Email")
	private String Email;
	@Column(name= "Login")
	private String Login;
	@Column(name= "Password")
	private String Password;
	
	
	
	
	public User() {
		super();
	}
	
	
	public User(int idUser, String name, String email, String login, String password) {
		super();
		this.idUser = idUser;
		Name = name;
		Email = email;
		Login = login;
		Password = password;
	}


	public User(String name, String email, String login, String password) {
		super();
		Name = name;
		Email = email;
		Login = login;
		Password = password;
	}


	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", Name=" + Name + ", Email=" + Email + ", Login=" + Login + ", Password="
				+ Password + "]";
	}
	
	
	
	
	
}
