package com.esprit.tn.repositories;

import org.springframework.data.repository.CrudRepository;

import com.esprit.tn.entities.Reclamation;
import com.esprit.tn.entities.Role;

public interface ReclamationRepository extends CrudRepository<Reclamation, Integer> {
	

}
