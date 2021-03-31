package com.esprit.tn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Bank;


@Repository
public interface BankRepository extends CrudRepository <Bank, Integer>{


	
}
