package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Contracts")
public class Contract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idContract;
	
	@Column(name="Contract_Type")
	@Enumerated(EnumType.STRING)
	private ContractType contracttype;

	public Contract() {
		super();
	}

	public Contract(int idContract, ContractType contracttype) {
		super();
		this.idContract = idContract;
		this.contracttype = contracttype;
	}

	public Contract(ContractType contracttype) {
		super();
		this.contracttype = contracttype;
	}

	public int getIdContract() {
		return idContract;
	}

	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}

	public ContractType getContracttype() {
		return contracttype;
	}

	public void setContracttype(ContractType contracttype) {
		this.contracttype = contracttype;
	}

	@Override
	public String toString() {
		return "Contract [idContract=" + idContract + ", contracttype=" + contracttype + "]";
	}
	
	
	
}
