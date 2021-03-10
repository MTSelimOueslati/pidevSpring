package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "Offers")
public class Offer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idOffer;
	private String Description;
	private float intrestRate;
	private float tex;
	private float salaireMin;
	

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonBackReference  
    private User user;
    

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonBackReference  
    private Bank bank;
	/**
	 * @return the idOffer
	 */
	public int getIdOffer() {
		return idOffer;
	}
	/**
	 * @param idOffer the idOffer to set
	 */
	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @return the intrestRate
	 */
	public float getIntrestRate() {
		return intrestRate;
	}
	/**
	 * @param intrestRate the intrestRate to set
	 */
	public void setIntrestRate(float intrestRate) {
		this.intrestRate = intrestRate;
	}
	/**
	 * @return the tex
	 */
	public float getTex() {
		return tex;
	}
	/**
	 * @param tex the tex to set
	 */
	public void setTex(float tex) {
		this.tex = tex;
	}
	/**
	 * @return the salaireMin
	 */
	public float getSalaireMin() {
		return salaireMin;
	}
	public Offer(int idOffer, String description, float intrestRate, float tex, float salaireMin) {
		super();
		this.idOffer = idOffer;
		Description = description;
		this.intrestRate = intrestRate;
		this.tex = tex;
		this.salaireMin = salaireMin;
	}
	public Offer() {
		super();
	}

	


	
}
