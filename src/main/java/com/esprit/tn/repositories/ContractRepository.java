package com.esprit.tn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.ContractType;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Integer> {
	
	@Query("SELECT c FROM Contract c WHERE c.type = :type")
	public List<Contract> findByType(@Param("type")ContractType type); 	
	
	
	@Query(value = "SELECT * FROM Contract WHERE id=(SELECT max(id) FROM Contract) && user_id=:idd", nativeQuery=true)
	public List<Contract> getContract(@Param("idd") int idd);
}
