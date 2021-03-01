package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Reclamation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idreclamation;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Description")
	private String description;

	public Reclamation() {
		super();
	}

	public Reclamation(int idreclamation, String subject, String description) {
		super();
		this.idreclamation = idreclamation;
		this.subject = subject;
		this.description = description;
	}

	public Reclamation(String subject, String description) {
		super();
		this.subject = subject;
		this.description = description;
	}

	public int getIdreclamation() {
		return idreclamation;
	}

	public void setIdreclamation(int idreclamation) {
		this.idreclamation = idreclamation;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Reclamation [idreclamation=" + idreclamation + ", subject=" + subject + ", description=" + description
				+ "]";
	}
	
	
	
}
