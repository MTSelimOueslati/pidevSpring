package com.esprit.tn.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.tn.entities.Ad;
import com.esprit.tn.entities.AdType;

@Repository
public interface IAdRepository extends JpaRepository<Ad,Integer >{

	@Query("Select a FROM ad u where a.adType= :adType")
	static
	List<Ad> findByAdType(@Param("AdType") AdType adType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Query("Select a FROM ad u where a.adType= :adType")
	List<Ad> findAllByAdType(@Param("AdType") AdType adType);
	

//	@Transactional
  //  @Modifying
    //@Query("DELETE from ad a where a.id= :id")
   // void deleteAdById(@Param("id") int id);



}
