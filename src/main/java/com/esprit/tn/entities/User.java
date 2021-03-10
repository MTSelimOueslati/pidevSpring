package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="user")
public class User implements Serializable , UserDetails  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private int phone_number;
	private String email;
	private String password;
	private String address;
	private boolean verified;

	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonBackReference
	private Role role;
	

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<Ad> ads;
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<Insurance> insurances;
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<Offer> offers;
/*	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonBackReference
	private Subscription sub;
*/
	

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<Contract> contracts;
	
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	//@JsonManagedReference
	private Set<Reclamation> reclamations;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	
	public Role getRole() {
		return role;
	}

	
	public void setRole(Role role) {
		this.role = role;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Role r = user.getRole();
		authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
	

}
