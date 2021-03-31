package com.esprit.tn.entities.util;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Transient;

import com.esprit.tn.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserForm {
	private String username;
	private int phone_number;
	private String email;
	private String password;
	private String address;
	private boolean verified;

	public UserForm() {
		super();
	}
	/**
	 * @return the name
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param name the name to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the phone_number
	 */
	public int getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	
}
