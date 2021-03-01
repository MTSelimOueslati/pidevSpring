package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Notification implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idnotification;
	
	@Column(name="Notification Text")
	private String notiftext;

	public Notification() {
		super();
	}

	public Notification(int idnotification, String notiftext) {
		super();
		this.idnotification = idnotification;
		this.notiftext = notiftext;
	}

	public Notification(String notiftext) {
		super();
		this.notiftext = notiftext;
	}

	public int getIdnotification() {
		return idnotification;
	}

	public void setIdnotification(int idnotification) {
		this.idnotification = idnotification;
	}

	public String getNotiftext() {
		return notiftext;
	}

	public void setNotiftext(String notiftext) {
		this.notiftext = notiftext;
	}

	@Override
	public String toString() {
		return "Notification [idnotification=" + idnotification + ", notiftext=" + notiftext + "]";
	}
	
	
	
}
