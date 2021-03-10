package com.esprit.tn.repositories;

import org.springframework.data.repository.CrudRepository;

import com.esprit.tn.entities.User;
import com.esprit.tn.entities.ConfirmationToken;

public interface ConfirmationTokenRepository extends  CrudRepository<ConfirmationToken, Long>{
	ConfirmationToken findByConfirmationToken(String confirmationToken);
	ConfirmationToken findByUser(User user);

}
