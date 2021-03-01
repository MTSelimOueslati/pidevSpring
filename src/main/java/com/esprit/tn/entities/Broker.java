package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Brokers")
public class Broker implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idBroker;

	public Broker(int idBroker) {
		super();
		this.idBroker = idBroker;
	}

	public Broker() {
		super();
	}

	public int getIdBroker() {
		return idBroker;
	}

	public void setIdBroker(int idBroker) {
		this.idBroker = idBroker;
	}

	@Override
	public String toString() {
		return "Broker [idBroker=" + idBroker + "]";
	}	
	
	
	

}
