package com.esprit.tn.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

	
	/*@Query(value = "SELECT id_user FROM `user` WHERE stripeid=:stid LIMIT 1", nativeQuery = true)
	public int getiduserbystripeid(@Param("stid") String stid);*/


			
	@Query(value = "SELECT id_strype FROM `user` WHERE user_id=:id", nativeQuery = true)
	public String getstripeidbyiduser(@Param("id") int id);
	
	
	

	
	@Query(value = "SELECT subscription_type FROM `subscriptions` WHERE user_user_id=:id", nativeQuery = true)
	public String getsubtype(@Param("id") int id);
	
	
}
