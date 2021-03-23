package com.esprit.tn.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class ConfirmationToken {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="token_id")
	    private long tokenid;

	    @Column(name="confirmation_token")
	    private String confirmationToken;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdDate;
	    
	    

	    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
		@JsonManagedReference
	    @JoinColumn(nullable = false, name = "userId")
	    private User user;

	    
	    public ConfirmationToken(User user) {
	        this.user = user;
	        createdDate = new Date();
	        confirmationToken = UUID.randomUUID().toString();
	    }
		public ConfirmationToken(long tokenid, String confirmationToken, Date createdDate, User user) {
			super();
			this.tokenid = tokenid;
			this.confirmationToken = confirmationToken;
			this.createdDate = createdDate;
			this.user = user;
		}

		public ConfirmationToken() {
			super();
		}

		/**
		 * @return the tokenid
		 */
		public long getTokenid() {
			return tokenid;
		}

		/**
		 * @param tokenid the tokenid to set
		 */
		public void setTokenid(long tokenid) {
			this.tokenid = tokenid;
		}

		/**
		 * @return the confirmationToken
		 */
		public String getConfirmationToken() {
			return confirmationToken;
		}

		/**
		 * @param confirmationToken the confirmationToken to set
		 */
		public void setConfirmationToken(String confirmationToken) {
			this.confirmationToken = confirmationToken;
		}

		/**
		 * @return the createdDate
		 */
		public Date getCreatedDate() {
			return createdDate;
		}

		/**
		 * @param createdDate the createdDate to set
		 */
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		/**
		 * @return the user
		 */
		public User getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(User user) {
			this.user = user;
		}

	    
	 
}
