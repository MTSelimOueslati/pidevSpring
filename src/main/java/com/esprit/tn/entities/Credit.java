package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Credits")
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
	
	@Column(name="Offers")
	private String Offers;

	public Credit() {
		super();
	}

	public Credit(int idCredit, float salary, float adprice, String offers) {
		super();
		this.idCredit = idCredit;
		this.salary = salary;
		this.adprice = adprice;
		this.Offers = offers;
	}
   
	public Credit(float salary, float adprice, String offers) {
		super();
		this.salary = salary;
		this.adprice = adprice;
		this.Offers = offers;
	}

	public int getIdCredit() {
		return idCredit;
	}

	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getAdprice() {
		return adprice;
	}

	public void setAdprice(float adprice) {
		this.adprice = adprice;
	}

	public String getOffers() {
		return Offers;
	}

	public void setOffers(String offers) {
		Offers = offers;
	}

	@Override
	public String toString() {
		return "Credit [idCredit=" + idCredit + ", salary=" + salary + ", adprice=" + adprice + ", Offers=" + Offers
				+ "]";
	}
	
	
}
