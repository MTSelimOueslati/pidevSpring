/*package com.esprit.tn.services;

import java.util.List;

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
	public void addAd(Ad a) {
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
		Ad.setState(a.getState());
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
	public List<Ad> getAllAds() {
		// TODO Auto-generated method stub
		return (List<Ad>) iAdRepository.findAll();
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
	
	

}
*/
