package com.esprit.tn.entities;

import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.asm.Advice.OffsetMapping.Factory.AdviceType;

@Entity
@Table(name= "Ad")
public class Ad {
	
private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idAd;
	
	@Column(name="ad")
	private String ad;
	
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
	
	@Column(name="Swimming_Pool")
	private boolean pool;
	
	@Column(name="Furnished")
	private boolean furnished;
	
	@Column(name= "dateCreated")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
    @Column(name="State")
	@Enumerated(EnumType.STRING)
    private State state;
  
    
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonBackReference  
    private User user;
    		
    	/**
	 * @return the idAd
	 */
	public int getIdAd() {
		return idAd;
	}

	/**
	 * @param idAd the idAd to set
	 */
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	/**
	 * @return the ad
	 */
	public String getAd() {
		return ad;
	}

	/**
	 * @param ad the ad to set
	 */
	public void setAd(String ad) {
		this.ad = ad;
	}

	/**
	 * @return the adType
	 */
	public AdType getAdType() {
		return adType;
	}

	/**
	 * @param adType the adType to set
	 */
	public void setAdType(AdType adType) {
		this.adType = adType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the nbrooms
	 */
	public int getNbrooms() {
		return nbrooms;
	}

	/**
	 * @param nbrooms the nbrooms to set
	 */
	public void setNbrooms(int nbrooms) {
		this.nbrooms = nbrooms;
	}

	/**
	 * @return the nbbath
	 */
	public int getNbbath() {
		return nbbath;
	}

	/**
	 * @param nbbath the nbbath to set
	 */
	public void setNbbath(int nbbath) {
		this.nbbath = nbbath;
	}

	/**
	 * @return the nbgarage
	 */
	public int getNbgarage() {
		return nbgarage;
	}

	/**
	 * @param nbgarage the nbgarage to set
	 */
	public void setNbgarage(int nbgarage) {
		this.nbgarage = nbgarage;
	}

	/**
	 * @return the garden
	 */
	public boolean isGarden() {
		return garden;
	}

	/**
	 * @param garden the garden to set
	 */
	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	/**
	 * @return the elevator
	 */
	public boolean isElevator() {
		return elevator;
	}

	/**
	 * @param elevator the elevator to set
	 */
	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	/**
	 * @return the pool
	 */
	public boolean isPool() {
		return pool;
	}

	/**
	 * @param pool the pool to set
	 */
	public void setPool(boolean pool) {
		this.pool = pool;
	}

	/**
	 * @return the furnished
	 */
	public boolean isFurnished() {
		return furnished;
	}

	/**
	 * @param furnished the furnished to set
	 */
	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Ad(String ad, AdType adType, String description, float price, String location, String area, int nbrooms,
			int nbbath, int nbgarage, boolean garden, boolean elevator, boolean pool, boolean furnished,
			Date dateCreated) {
		super();
		this.ad = ad;
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
		this.dateCreated = dateCreated;
		
	
	}

	public Ad() {
		super();
	}

	
	
}
