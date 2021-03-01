package com.esprit.tn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Media implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id")
	private int idMedia;
	
	@Column(name="Media Type")
	@Enumerated(EnumType.STRING)
	private MediaType mediatype;

	@ManyToOne
	@JoinColumn(name = "idAd", referencedColumnName = "Ad", insertable = false, updatable = false)
	private Ad ad;
	
	
	public Media() {
		super();
	}

	public Media(int idMedia, MediaType mediatype) {
		super();
		this.idMedia = idMedia;
		this.mediatype = mediatype;
	}

	public Media(MediaType mediatype) {
		super();
		this.mediatype = mediatype;
	}

	public int getIdMedia() {
		return idMedia;
	}

	public void setIdMedia(int idMedia) {
		this.idMedia = idMedia;
	}

	public MediaType getMediatype() {
		return mediatype;
	}

	public void setMediatype(MediaType mediatype) {
		this.mediatype = mediatype;
	}

	@Override
	public String toString() {
		return "Media [idMedia=" + idMedia + ", mediatype=" + mediatype + "]";
	}
	
	
}
