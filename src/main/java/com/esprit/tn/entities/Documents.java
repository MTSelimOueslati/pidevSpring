package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Documents implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idDocuments;
	
	@Column(name="Identity")
	private String Identity;
	
	@Column(name="Payslip")
	private String Payslip;
	
	@Column(name="Letter Of Commitment")
	private String locommitement;
	
	@Column(name="Payment Justification")
	private float paymentjustification;

	public Documents() {
		super();
	}

	public Documents(int idDocuments, String identity, String payslip, String locommitement,
			float paymentjustification) {
		super();
		this.idDocuments = idDocuments;
		Identity = identity;
		Payslip = payslip;
		this.locommitement = locommitement;
		this.paymentjustification = paymentjustification;
	}

	public Documents(String identity, String payslip, String locommitement, float paymentjustification) {
		super();
		Identity = identity;
		Payslip = payslip;
		this.locommitement = locommitement;
		this.paymentjustification = paymentjustification;
	}

	public int getIdDocuments() {
		return idDocuments;
	}

	public void setIdDocuments(int idDocuments) {
		this.idDocuments = idDocuments;
	}

	public String getIdentity() {
		return Identity;
	}

	public void setIdentity(String identity) {
		Identity = identity;
	}

	public String getPayslip() {
		return Payslip;
	}

	public void setPayslip(String payslip) {
		Payslip = payslip;
	}

	public String getLocommitement() {
		return locommitement;
	}

	public void setLocommitement(String locommitement) {
		this.locommitement = locommitement;
	}

	public float getPaymentjustification() {
		return paymentjustification;
	}

	public void setPaymentjustification(float paymentjustification) {
		this.paymentjustification = paymentjustification;
	}

	@Override
	public String toString() {
		return "Documents [idDocuments=" + idDocuments + ", Identity=" + Identity + ", Payslip=" + Payslip
				+ ", locommitement=" + locommitement + ", paymentjustification=" + paymentjustification + "]";
	}
	
	
	
}
