package com.esprit.tn.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	/*@Query(" select u from User u where u.username = ?1")
    Optional<User> findUserByUsername(String Name);*/
	
	@Query(" select u from User u where u.username = ?1")
    User findUserByUsername(String username);
	
	
	//public User findByUserId(long id);
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
