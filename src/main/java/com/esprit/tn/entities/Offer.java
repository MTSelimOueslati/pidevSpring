package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Offer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idOffer;
	
	@Column(name="Type Offer")
	private String typeoffer;
	
	@ManyToOne
	@JoinColumn(name= "idBank")
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name= "idCredit")
	private Credit credit;

	public Offer() {
		super();
	}

	public Offer(int idOffer, String typeoffer, Bank bank) {
		super();
		this.idOffer = idOffer;
		this.typeoffer = typeoffer;
		this.bank = bank;
	}

	public Offer(String typeoffer, Bank bank) {
		super();
		this.typeoffer = typeoffer;
		this.bank = bank;
	}

	public int getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}

	public String getTypeoffer() {
		return typeoffer;
	}

	public void setTypeoffer(String typeoffer) {
		this.typeoffer = typeoffer;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Offer [idOffer=" + idOffer + ", typeoffer=" + typeoffer + ", bank=" + bank + "]";
	}
	
	
	
}
