package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Moderators")
public class Moderator extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idModerator;

	
	
	public Moderator() {
		super();
	}



	public Moderator(int idModerator) {
		super();
		this.idModerator = idModerator;
	}



	public int getIdModerator() {
		return idModerator;
	}



	public void setIdModerator(int idModerator) {
		this.idModerator = idModerator;
	}



	@Override
	public String toString() {
		return "Moderator [idModerator=" + idModerator + "]";
	}
	
	
}
