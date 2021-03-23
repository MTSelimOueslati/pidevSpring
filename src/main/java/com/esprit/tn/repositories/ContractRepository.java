package com.esprit.tn.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.ContractType;

public interface ContractRepository extends CrudRepository<Contract, Integer> {
	
	@Query("SELECT c FROM Contract c WHERE c.type = :type")
	public List<Contract> findByType(@Param("type")ContractType type); 	
}
