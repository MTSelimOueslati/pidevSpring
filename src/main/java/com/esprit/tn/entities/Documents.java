package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "document")
public class Documents implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	
	@Column(name="fichedepaie")
	private String fichedepaie;
	
	@Column(name="piecedidentite")
	private String piecedidentite;
	
	@Column(name="lettredengagement")
	private String lettredengagement;
	
	@Column(name="cautionnement")
	private String cautionnement;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "user_id")
    private User user;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFichedepaie() {
		return fichedepaie;
	}

	public void setFichedepaie(String fichedepaie) {
		this.fichedepaie = fichedepaie;
	}

	public String getPiecedidentite() {
		return piecedidentite;
	}

	public void setPiecedidentite(String piecedidentite) {
		this.piecedidentite = piecedidentite;
	}

	public String getLettredengagement() {
		return lettredengagement;
	}

	public void setLettredengagement(String lettredengagement) {
		this.lettredengagement = lettredengagement;
	}

	public String getCautionnement() {
		return cautionnement;
	}

	public void setCautionnement(String cautionnement) {
		this.cautionnement = cautionnement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Documents(String fichedepaie, String piecedidentite, String lettredengagement, String cautionnement) {
		super();
		this.fichedepaie = fichedepaie;
		this.piecedidentite = piecedidentite;
		this.lettredengagement = lettredengagement;
		this.cautionnement = cautionnement;
	}

	
	public Documents() {
		super();
	}


	
	
	
	
}
