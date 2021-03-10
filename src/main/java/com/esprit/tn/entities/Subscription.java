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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Subscriptions")
public class Subscription {

	
private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idsubscription;
	
	@Column(name="Offer")
	private float offer;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Expiration_Date")
	private Date expirationdate;
	
	@Column(name="Subscription_Type")
	@Enumerated(EnumType.STRING)
	private SubType subtype;
	
	/*@OneToMany(cascade = CascadeType.PERSIST,mappedBy="subscription",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<User> user;*/

	public Subscription() {
		super();
	}

	public Subscription(int idsubscription, float offer, Date expirationdate, SubType subtype) {
		super();
		this.idsubscription = idsubscription;
		this.offer = offer;
		this.expirationdate = expirationdate;
		this.subtype = subtype;
	}

	public Subscription(float offer, Date expirationdate, SubType subtype) {
		super();
		this.offer = offer;
		this.expirationdate = expirationdate;
		this.subtype = subtype;
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

	public Date getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}

	public SubType getSubtype() {
		return subtype;
	}

	public void setSubtype(SubType subtype) {
		this.subtype = subtype;
	}

	@Override
	public String toString() {
		return "Subscription [idsubscription=" + idsubscription + ", offer=" + offer + ", expirationdate="
				+ expirationdate + ", subtype=" + subtype + "]";
	}
	
	
}
