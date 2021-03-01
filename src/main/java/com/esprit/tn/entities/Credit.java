package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Credit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idCredit;
	
	@Column(name="Salary")
	private float salary;
	
	@Column(name="AdPrice")
	private float adprice;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy= "Offer")
	private Set<Offer> Offers;
}
