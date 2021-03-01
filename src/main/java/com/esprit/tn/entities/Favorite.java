package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Favorite implements Serializable {

private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idfavorite;
	
	@Column(name="Favorite Name")
	private String favoritename;

	
	 
	public Favorite() {
		super();
	}



	public Favorite(int idfavorite, String favoritename) {
		super();
		this.idfavorite = idfavorite;
		this.favoritename = favoritename;
	}



	public Favorite(String favoritename) {
		super();
		this.favoritename = favoritename;
	}



	public int getIdfavorite() {
		return idfavorite;
	}



	public void setIdfavorite(int idfavorite) {
		this.idfavorite = idfavorite;
	}



	public String getFavoritename() {
		return favoritename;
	}



	public void setFavoritename(String favoritename) {
		this.favoritename = favoritename;
	}



	@Override
	public String toString() {
		return "Favorite [idfavorite=" + idfavorite + ", favoritename=" + favoritename + "]";
	}
	
	
	
}
