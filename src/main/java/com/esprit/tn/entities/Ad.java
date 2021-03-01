package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Ad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idAd;
	
	@Column(name="AdType")
	@Enumerated(EnumType.STRING)
	private AdType adType;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Price")
	private float price;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Area")
	private String area;
	
	@Column(name="NbRooms")
	private int nbrooms;
	
	@Column(name="NbBath")
	private int nbbath;
	
	@Column(name="NbGarage")
	private int nbgarage;
	
	@Column(name="Garden")
	private boolean garden;
	
	@Column(name="Elevator")
	private boolean elevator;
	
	@Column(name="Swimming Pool")
	private boolean pool;
	
	@Column(name="Furnished")
	private boolean furnished;
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	
	@Column(name="State")
	@Enumerated(EnumType.STRING)
	private State state;

	@OneToMany(cascade= CascadeType.ALL, mappedBy= "Visit")
	private Set<Visit> visits;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy= "Media")
	private Set<Media> media;
	
	public Ad() {
		super();
	}

	
	
	public Ad(int idAd, AdType adType, String description, float price, String location, String area, int nbrooms,
			int nbbath, int nbgarage, boolean garden, boolean elevator, boolean pool, boolean furnished, User user,
			State state) {
		super();
		this.idAd = idAd;
		this.adType = adType;
		this.description = description;
		this.price = price;
		this.location = location;
		this.area = area;
		this.nbrooms = nbrooms;
		this.nbbath = nbbath;
		this.nbgarage = nbgarage;
		this.garden = garden;
		this.elevator = elevator;
		this.pool = pool;
		this.furnished = furnished;
		this.user = user;
		this.state = state;
	}



	
	
	public Ad(AdType adType, String description, float price, String location, String area, int nbrooms, int nbbath,
			int nbgarage, boolean garden, boolean elevator, boolean pool, boolean furnished, User user, State state) {
		super();
		this.adType = adType;
		this.description = description;
		this.price = price;
		this.location = location;
		this.area = area;
		this.nbrooms = nbrooms;
		this.nbbath = nbbath;
		this.nbgarage = nbgarage;
		this.garden = garden;
		this.elevator = elevator;
		this.pool = pool;
		this.furnished = furnished;
		this.user = user;
		this.state = state;
	}



	public int getIdAd() {
		return idAd;
	}

	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public AdType getAdType() {
		return adType;
	}

	public void setAdType(AdType adType) {
		this.adType = adType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getNbrooms() {
		return nbrooms;
	}

	public void setNbrooms(int nbrooms) {
		this.nbrooms = nbrooms;
	}

	public int getNbbath() {
		return nbbath;
	}

	public void setNbbath(int nbbath) {
		this.nbbath = nbbath;
	}

	public int getNbgarage() {
		return nbgarage;
	}

	public void setNbgarage(int nbgarage) {
		this.nbgarage = nbgarage;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Ad [idAd=" + idAd + ", adType=" + adType + ", description=" + description + ", price=" + price
				+ ", location=" + location + ", area=" + area + ", nbrooms=" + nbrooms + ", nbbath=" + nbbath
				+ ", nbgarage=" + nbgarage + ", garden=" + garden + ", elevator=" + elevator + ", pool=" + pool
				+ ", furnished=" + furnished + ", user=" + user + ", state=" + state + "]";
	}
	
	
	
}
