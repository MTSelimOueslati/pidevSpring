package com.esprit.tn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.esprit.tn.entities.Documents;


public interface DocumentsRepository extends CrudRepository<Documents, Integer> , JpaRepository<Documents,Integer>{

	//@Query("select * from documents d user u where d.userid=u.userid and d.userid=?1 ")
	
	
}
