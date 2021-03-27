package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
	@Lob
    private byte[]fichedepaie;
	
	@Column(name="piecedidentite")
	@Lob
    private byte[] piecedidentite;
	
	@Column(name="lettredengagement")
	@Lob
    private byte[] lettredengagement;
	
	@Column(name="cautionnement")
	@Lob
    private byte[] cautionnement;
	
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

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	



	
	public byte[] getFichedepaie() {
		return fichedepaie;
	}

	public void setFichedepaie(byte[] fichedepaie) {
		this.fichedepaie = fichedepaie;
	}

	public byte[] getPiecedidentite() {
		return piecedidentite;
	}

	public void setPiecedidentite(byte[] piecedidentite) {
		this.piecedidentite = piecedidentite;
	}

	public byte[] getLettredengagement() {
		return lettredengagement;
	}

	public void setLettredengagement(byte[] lettredengagement) {
		this.lettredengagement = lettredengagement;
	}

	public byte[] getCautionnement() {
		return cautionnement;
	}

	public void setCautionnement(byte[] cautionnement) {
		this.cautionnement = cautionnement;
	}

	public Documents() {
		super();
	}

	public Documents(byte[] fichedepaie, byte[] piecedidentite, byte[] lettredengagement, byte[] cautionnement,
			User user) {
		super();
		this.fichedepaie = fichedepaie;
		this.piecedidentite = piecedidentite;
		this.lettredengagement = lettredengagement;
		this.cautionnement = cautionnement;
		this.user = user;
	}


	
	
	
	
}
