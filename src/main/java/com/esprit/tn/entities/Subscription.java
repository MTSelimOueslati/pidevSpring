package com.esprit.tn.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Subscriptions")
public class Subscription {

	
//private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idsubscription;
	
	@Column(name="Offer")
	private float offer;
	
	@Temporal(TemporalType.DATE)
	Date startDate;
	@Temporal(TemporalType.DATE)
	Date endDate;
	
	@Column(name="Subscription_Type")

	String subtype;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	//@JsonManagedReference
	private User user;

	public Subscription() {
		super();
	}



	public int getIdsubscription() {
		return idsubscription;
	}

	public void setIdsubscription(int idsubscription) {
		this.idsubscription = idsubscription;
	}

	public float getOffer() {
		return offer;
	}

	public void setOffer(float offer) {
		this.offer = offer;
	}



	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	public Subscription(float offer, Date startDate, Date endDate, String subtype) {
		super();
		this.offer = offer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.subtype = subtype;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}


	
	
}
