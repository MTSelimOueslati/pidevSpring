/*package com.esprit.tn.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Ad;

@Repository
public interface IAdRepository extends CrudRepository<Ad,Integer >{



	@Transactional
    @Modifying
    @Query("DELETE from ad a where a.id= :id")
    void deleteAdById(@Param("id") int id);



}
*/