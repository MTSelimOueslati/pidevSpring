package com.esprit.tn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Subscription;
import com.esprit.tn.repositories.UserRepository;
import com.esprit.tn.services.PaymentService;
import com.esprit.tn.services.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	@Autowired
	SubscriptionService subservice;
	
	@Autowired
	PaymentService paymentserv;
	
	@Autowired
	UserRepository userrep;
	
	
	@PostMapping("/ActivateSubscription/{id}")
	@ResponseBody
	private int addSubsciption(@RequestBody Subscription subscription,@PathVariable("id") int userid)   
	{  
		String id = paymentserv.createCustomer(userrep.findByUserId(userid));
		userrep.findByUserId(userid).setIdStrype(id);
		userrep.save(userrep.findByUserId(userid));
		subservice.ActivateSubscription(subscription,userid);
		
		return subscription.getIdsubscription();  
	} 
	
	@PutMapping("/updatesub/{idsubscription}")
	private Subscription updateSubscription(@RequestBody Subscription sub, @PathVariable("idsubscription") int idsubscription)   
	{  
	
		subservice.updateSubscription(sub, idsubscription);  
		return sub;  
	}

}
