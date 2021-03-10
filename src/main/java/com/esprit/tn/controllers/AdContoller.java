/*package com.esprit.tn.controllers;

import java.util.List;

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
import com.esprit.tn.services.AdServiceImpl;

@RestController
public class AdContoller {

	@Autowired
	AdServiceImpl AdServiceImpl;
	
	@PostMapping("/ad/add-ad")
    @ResponseBody
    private Ad addAd(@RequestBody Ad ad)
    {
		AdServiceImpl.addAd(ad);
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
        return AdServiceImpl.getAllAds();
    }
}
*/