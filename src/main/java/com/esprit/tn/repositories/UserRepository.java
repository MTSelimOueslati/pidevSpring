package com.esprit.tn.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.tn.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(" select u from User u where u.Name = ?1")
    Optional<User> findUserByName(String Name);
	
	@Query(" select u from User u where u.Name = ?1")
    User findByName(String Name);
	
	
	public User findByUserId(int id);

}
