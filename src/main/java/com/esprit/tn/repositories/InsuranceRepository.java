package com.esprit.tn.repositories;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.tn.entities.Insurance;



public interface InsuranceRepository extends CrudRepository<Insurance, Integer>{
	
	@Query("SELECT i FROM Insurance i WHERE i.name = :name")
	public Insurance findByName(@Param("name")String name); 

}
