package com.esprit.tn.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	/*@Query(" select u from User u where u.username = ?1")
    Optional<User> findUserByUsername(String Name);*/
	
	@Query(" select u from User u where u.username = ?1")
    User findUserByUsername(String username);
	
	
	@Query(value = "SELECT username FROM user INNER JOIN contract on user.id=contract.user_id where user_id=:idd LIMIT 1", nativeQuery = true)
	public String getcontractnameuser(@Param("idd") int idd);
	//public User findByUserId(long id);
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
