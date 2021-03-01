package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Visit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idVisit;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Visit Date")
	private Date visitdate;
	
	@Column(name="Visit Type")
	@Enumerated(EnumType.STRING)
	private VisitType visitType;

	@ManyToOne
	@JoinColumn(name= "idAd")
	private Ad ad;
	
	public Visit() {
		super();
	}

	public Visit(int idVisit, Date visitdate, VisitType visitType) {
		super();
		this.idVisit = idVisit;
		this.visitdate = visitdate;
		this.visitType = visitType;
	}

	public Visit(Date visitdate, VisitType visitType) {
		super();
		this.visitdate = visitdate;
		this.visitType = visitType;
	}

	public int getIdVisit() {
		return idVisit;
	}

	public void setIdVisit(int idVisit) {
		this.idVisit = idVisit;
	}

	public Date getVisitdate() {
		return visitdate;
	}

	public void setVisitdate(Date visitdate) {
		this.visitdate = visitdate;
	}

	public VisitType getVisitType() {
		return visitType;
	}

	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}

	@Override
	public String toString() {
		return "Visit [idVisit=" + idVisit + ", visitdate=" + visitdate + ", visitType=" + visitType + "]";
	}
	
	
}
