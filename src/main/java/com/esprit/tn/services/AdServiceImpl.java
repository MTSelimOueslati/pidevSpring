package com.esprit.tn.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Ad;
import com.esprit.tn.entities.AdType;
import com.esprit.tn.repositories.IAdRepository;

@Service
public class AdServiceImpl implements IAdService {
	
	@Autowired 
	private IAdRepository iAdRepository;

	@Override
	public void addAd(Ad a,int userid) {
		// TODO Auto-generated method stub
		iAdRepository.save(a);
	}

	@Override
	public Ad updateAd(Ad a, int id) {
		// TODO Auto-generated method stub
		Ad Ad = iAdRepository.findById(id).get();
		Ad.setDescription(a.getDescription());
		Ad.setLocation(a.getLocation());
		Ad.setNbbath(a.getNbbath());
		Ad.setNbgarage(a.getNbgarage());
		Ad.setNbrooms(a.getNbrooms());
		Ad.setPrice(a.getPrice());
		Ad.setAdType(a.getAdType());
		Ad.setArea(a.getArea());
	//	Ad.setState(a.getState());
		Ad.setElevator(a.isPool());
		Ad.setFurnished(a.isFurnished());
		Ad.setPool(a.isPool());
		Ad.setGarden(a.isGarden());
	
		
		//Ad.setPhoto(a.getPhoto());
		//Ad.setVideo(a.getVideo());

		iAdRepository.save(Ad);
		return Ad;
		
	}

	
	@Override
    public void deleteAd(int id) {
        // TODO Auto-generated method stub
        iAdRepository.deleteById(id);

    }
	@Override
	public Ad getAdById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ad> filterAd(AdType a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> percentageRenting() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Double nbAd = (double)iAdRepository.count();
		
		List<Ad> renting = IAdRepository.findByAdType(AdType.Renting);
		for (Ad ad: renting) {
		List<Ad> Ad = iAdRepository.findAll();

		double d = (double) Math.round(renting.size() / nbAd * 100) / 100;
		map.put(ad.getAd(), (int) (d * 100));

		}
		System.out.println(map);
		return map;
	}

	@Override
	public List<Ad> getAllAd() {
		List<Ad>ads= new ArrayList<Ad>();

		iAdRepository.findAll().forEach(a ->ads.add(a));
		return ads;
	}
	
	@Override
	public List<Ad> findAllByAdType(AdType adtype) {
		// TODO Auto-generated method stub
		return iAdRepository.findAllByAdType(adtype);
	}

	@Override
	public List<Ad> findByAdType(AdType adtype) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	public List<Ad> findByType(AdType adType) {
		// TODO Auto-generated method stub
		return  iAdRepository.findByType(adType);
	}*/
	

	
	/*
	 * 		
		for (Ad ad: renting) {
			if (ad.get().isEmpty()) {
				map.put(ad.getFirstName(), 0);
			} else {
				List<Ad> consult = iAdRepository.findConsultationByDoctor(user);
				double d = (double) Math.round(consult.size() / nbConsult * 100) / 100;
				map.put(user.getFirstName(), (int) (d * 100));
			}
		}
		*/
	

}

