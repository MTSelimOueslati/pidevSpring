package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "Banks")
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idBank;
	
	@Column(name="Name")
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<Offer> offers;
	
	
	
	
	

	
	
	public Bank() {
		super();
	}

	public Bank(String name, Set<Offer> offers) {
		super();
		this.name = name;
		this.offers = offers;
	}

	

	public Bank(String name) {
		super();
		this.name = name;
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

	

	@Override
	public String toString() {
		return "Bank [idBank=" + idBank + ", name=" + name + "]";
	}
	
	
	
}
