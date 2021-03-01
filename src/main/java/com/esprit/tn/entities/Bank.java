package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idBank;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Interest Rate")
	private float interestrate;

	@OneToMany(cascade= CascadeType.ALL, mappedBy= "Bank")
	private Set<Offer> Offers;
	
	
	public Bank() {
		super();
	}

	public Bank(int idBank, String name, float interestrate) {
		super();
		this.idBank = idBank;
		this.name = name;
		this.interestrate = interestrate;
	}

	public Bank(String name, float interestrate) {
		super();
		this.name = name;
		this.interestrate = interestrate;
	}

	public int getIdBank() {
		return idBank;
	}

	public void setIdBank(int idBank) {
		this.idBank = idBank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(float interestrate) {
		this.interestrate = interestrate;
	}

	@Override
	public String toString() {
		return "Bank [idBank=" + idBank + ", name=" + name + ", interestrate=" + interestrate + "]";
	}
	
	
	
}
