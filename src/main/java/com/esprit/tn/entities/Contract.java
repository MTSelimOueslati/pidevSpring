package com.esprit.tn.entities;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})

@Entity
@Table(name= "Contract")
public class Contract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name="Contract_Type")
	@Enumerated(EnumType.STRING)
	private ContractType type;

	@Column(name="Buyer")
	private String buyer;
	
	@Column(name="Seller")
	private String seller;
	
	@Column(name="sum")
	private float sum;
	
	@Column(name="address")
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;

	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonBackReference
	private User user;
	
	public Contract() {
		super();
	}




	




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}







	public ContractType getType() {
		return type;
	}









	public void setType(ContractType type) {
		this.type = type;
	}









	/**
	 * @return the buyer
	 */
	public String getBuyer() {
		return buyer;
	}




	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}




	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}




	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}




	/**
	 * @return the sum
	 */
	public float getSum() {
		return sum;
	}




	/**
	 * @param sum the sum to set
	 */
	public void setSum(float sum) {
		this.sum = sum;
	}




	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}




	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}




	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}









	public User getUser() {
		return user;
	}









	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
