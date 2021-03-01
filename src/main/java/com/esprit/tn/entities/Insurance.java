package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Insurance implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idinsurance;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Website")
	private String website;

	public Insurance() {
		super();
	}

	public Insurance(int idinsurance, String name, String website) {
		super();
		this.idinsurance = idinsurance;
		this.name = name;
		this.website = website;
	}

	public Insurance(String name, String website) {
		super();
		this.name = name;
		this.website = website;
	}

	public int getIdinsurance() {
		return idinsurance;
	}

	public void setIdinsurance(int idinsurance) {
		this.idinsurance = idinsurance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Insurance [idinsurance=" + idinsurance + ", name=" + name + ", website=" + website + "]";
	}
	
	
}
