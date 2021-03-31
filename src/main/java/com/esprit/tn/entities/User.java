package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@JsonIgnoreProperties({"hibernateLazyInitializer"})

@Entity
@Table(	name = "user", 
	uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email") 
})
public class User implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;
	private int phone_number;
	private String email;
	private String password;
	private String address;
	private boolean verified;
	private boolean subscribed;
	private String idStrype;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"user"})
	private Role role;
	

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"user"})
	private Set<Ad> ads;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonManagedReference
	private Documents documents;
	
	
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"user"})
	private Set<Offer> offers;
	

	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	@JsonManagedReference
	private Set<Contract> contracts;
	
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"user"})
	private Set<Reclamation> reclamations;

	
	
	
	
	public String getIdStrype() {
		return idStrype;
	}

	public void setIdStrype(String idStrype) {
		this.idStrype = idStrype;
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


	
	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Role r = user.getRole();
		authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		return null;
	}*/



	public Set<Role> getRoles() {
		return roles;
	}

	public User() {
		super();
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public Documents getDocuments() {
		return documents;
	}

	public void setDocuments(Documents documents) {
		this.documents = documents;
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
