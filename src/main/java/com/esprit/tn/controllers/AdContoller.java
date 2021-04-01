package com.esprit.tn.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Ad;
import com.esprit.tn.entities.AdType;
import com.esprit.tn.services.AdServiceImpl;

@RestController
public class AdContoller {

	@Autowired
	AdServiceImpl AdServiceImpl;
	
	@PostMapping("/ad/add-ad/{id}")
    @ResponseBody
    private Ad addAd(@RequestBody Ad ad,@PathVariable("id") int userid)
    {
		AdServiceImpl.addAd(ad,userid);
        return ad;
    }
	
	@PutMapping("/ad/update/{id}")
	
	private Ad updateAd(@RequestBody Ad ad, @PathVariable("id")int id ) {
		AdServiceImpl.updateAd(ad, id);
		return AdServiceImpl.updateAd(ad, id);
	}

	@DeleteMapping("/ad/delete/{id}")
    public void deleteAdById(@PathVariable("id") int id) {
        AdServiceImpl.deleteAd(id);
    }
	
	@GetMapping("/ad/getAll")
    public List<Ad> getAllAds() {
        return AdServiceImpl.getAllAd();
    }
	
	@GetMapping("/ad/getbytype/{adType}")
	public List<Ad> findByType( @PathVariable AdType adType) 
	{
         List<Ad> a = AdServiceImpl.findByAdType(adType);
         return a;
	}
	
	@GetMapping("ad/static")
	public Map<String, Integer> percentageParticipationByDoctor() {
		return AdServiceImpl.percentageRenting();
	}

}
