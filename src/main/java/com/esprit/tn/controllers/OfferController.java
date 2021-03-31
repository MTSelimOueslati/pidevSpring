package com.esprit.tn.controllers;

import java.util.HashMap;
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

import com.esprit.tn.entities.Bank;
import com.esprit.tn.entities.Offer;
import com.esprit.tn.services.OfferServiceImpl;

@RestController
public class OfferController {
	
	
	
	
	@Autowired
    OfferServiceImpl offerservimpl;

    //add offer
    @PostMapping("/offer/add-Offer")
    @ResponseBody
    private Offer addOffer(@RequestBody Offer offer)
    {
       offerservimpl.addOffer(offer); 
        return offer;
    }
	
	
	//get offers
    @GetMapping("/offer/getAll")
    public List<Offer> getAllOffers() {
        return offerservimpl.getAllOffers();
    }

    @GetMapping("/offer/getTri")
    public List<Offer> BestOffers() {
        return offerservimpl.BestOffers();
    }

    @GetMapping("/offer/sum")
    public int Sum() {
        return offerservimpl.Sum();
    }
    
    @GetMapping("offer/stat")
    public HashMap<String, String> Percentage(){
    	return offerservimpl.Percentage();
    }
    
    @DeleteMapping("/offer/delete/{id}")
    public void deleteOfferById(@PathVariable("id") int id) {
        offerservimpl.deleteOffer(id);
    }
    
    
    
    @PutMapping("/offer/update/{id}")      
    private Offer updateOffer(@RequestBody Offer offer, @PathVariable("id")int id )
    {        
    	offerservimpl.updateOffer(offer, id); 
    return offerservimpl.updateOffer(offer, id);    
    }
    
    //offer
    @PutMapping("offer/getoffer/{id}")
    public Offer getOffer(@PathVariable("id") int id) {
    	return offerservimpl.getOffer(id);
    }
    
    
    //oeeeeeeeeeeeee
    @PutMapping("offer/addUser/{id}")
    public Offer  UserCount(@PathVariable("id")int id) {
    	return offerservimpl.UserCount(id);
    	
    }
    
    
    //salary check 
    @GetMapping("offer/test/{id}/{salary}")
    private Offer test(@PathVariable int id, @PathVariable float salary) {
       	return offerservimpl.test(id, salary);
    } 
    
    //c
   
    @GetMapping("offer/testing/{id}/{salary}/{price}")
    private float  calcul(@PathVariable int id, @PathVariable float salary, @PathVariable float price) {
       	return offerservimpl.calcul(id, salary, price);
    } 
    
    @GetMapping("offer/loanValue/{id}/{nbm}")
    private float loanAmont(@PathVariable int id, @PathVariable float nbm)   {
    	return offerservimpl.loanAmont(id,nbm);
    }
    
    @GetMapping("offer/nbmonths/{id}/{amont}")
    private float nbmonths(@PathVariable int id, @PathVariable float amont)   {
    	return offerservimpl.nbmonths(id,amont);
    }
    
    @GetMapping("offer/monthlypayment/{id}/{amont}/{nbm}")
    private float monthlypayment(@PathVariable int id, @PathVariable float amont, @PathVariable float nbm)   {
    	return offerservimpl.monthlypayment(id,amont,nbm);
    }
    
    
}
