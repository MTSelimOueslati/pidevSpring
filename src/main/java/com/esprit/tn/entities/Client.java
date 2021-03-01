package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Clients")
public class Client extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idClient;	
	
	@Column(name="Phone Number")
	private int phone;
	
	@Column(name="Address")
	private String address;
		
	@Column(name="Documents")
	private Documents documents;

	public Client() {
		super();
	}

	public Client(int idClient, int phone, String address, Documents documents) {
		super();
		this.idClient = idClient;
		this.phone = phone;
		this.address = address;
		this.documents = documents;
	}

	public Client(int phone, String address, Documents documents) {
		super();
		this.phone = phone;
		this.address = address;
		this.documents = documents;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Documents getDocuments() {
		return documents;
	}

	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", phone=" + phone + ", address=" + address + ", documents=" + documents
				+ "]";
	}
	
	

	
	
}
