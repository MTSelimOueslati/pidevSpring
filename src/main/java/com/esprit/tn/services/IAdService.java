package com.esprit.tn.services;

import java.util.List;
import java.util.Map;

import com.esprit.tn.entities.Ad;
import com.esprit.tn.entities.AdType;

public interface IAdService {

	void addAd(Ad a, int userid);
    public Ad updateAd(Ad a, int id);
    public void deleteAd(int id);
        
   
    public Ad getAdById(int id);
   public List<Ad> getAllAd(); 
   public List<Ad> filterAd(AdType a);

 //  public List<Ad> findByType(AdType adType);
	Map<String, Integer> percentageRenting();
	List<Ad> findByAdType(AdType adtype);
	List<Ad> findAllByAdType(AdType adtype);
	

	

}
