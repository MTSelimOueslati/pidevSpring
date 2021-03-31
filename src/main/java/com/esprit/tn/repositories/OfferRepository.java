package com.esprit.tn.repositories;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

public List<Offer> findAllByOrderByNmbDesc();

@Query(value = "SELECT sum(o.nmb) from Offer o")
public int sumNmbAmount();
	
@Query(value ="SELECT MAX(o.id) FROM Offer o")
public int MAX();

}
