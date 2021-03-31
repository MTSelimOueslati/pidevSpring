package com.esprit.tn.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Role;
import com.esprit.tn.entities.Subscription;
import com.esprit.tn.entities.User;
import com.esprit.tn.repositories.SubscriptionRepository;
import com.esprit.tn.repositories.UserRepository;
import com.esprit.tn.services.PaymentService;
import com.esprit.tn.services.SubscriptionService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.model.issuing.CardDetails;


@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	@Autowired
	SubscriptionService subservice;
	
	@Autowired
	PaymentService paymentserv;
	
	@Autowired
	UserRepository userrep;
	
	@Autowired
	SubscriptionRepository sbr;
	
	
	
	@PostMapping(value = "/addclient")
	@ResponseBody	
	public void ajouterClient(@RequestBody Customer customer)throws StripeException{
		Stripe.apiKey="sk_test_51ITYUZKuxtPIEeD5lsPmKh2sG7jhzhhOpuBjXgXg4PL8cdjL79dL038v5SXcR32Ro9yIRxpfX6KfPQrQSxmR1h1p00xID5MdR4";
		customer.setEmail(customer.getEmail());
		Map<String,Object> mp =new HashMap<String , Object>();
		mp.put("email",customer.getEmail());
		Customer.create(mp);
		//coté database	
		User user = new User();
		user.setEmail(customer.getEmail());
		user.setUsername(customer.getDescription());
		//Role rt = Role.;
		Set<Role> r = user.getRoles();
		//r.setRoleName(rt);
		user.setRoles(r);
		
		//getting id of customer
		Map<String, Object> options = new HashMap<>();
		options.put("email", customer.getEmail());
		List<Customer> customers = Customer.list(options).getData();
		     String ola = customers.get(0).getId();
		     System.out.println(customer);
		     user.setIdStrype(ola);;
		
		userrep.save(user);
		user = userrep.findById(user.getId()).orElse(null);
		user.setUsername(user.getUsername());
		user.setPhone_number(user.getPhone_number());
		user.setAddress(user.getAddress());
		
		//setting default values
		
        
		 userrep.save(user);
		
		
	}

	
	@PostMapping(value = "/addcart/{userid}")
	@ResponseBody	
	public void addcart(@RequestBody CardDetails x , @PathVariable("userid")int userid)throws StripeException{
		
		Stripe.apiKey="sk_test_51ITYUZKuxtPIEeD5lsPmKh2sG7jhzhhOpuBjXgXg4PL8cdjL79dL038v5SXcR32Ro9yIRxpfX6KfPQrQSxmR1h1p00xID5MdR4";
		
		Map<String, Object> retrieveParams =new HashMap<>();
		
		List<String> expandList = new ArrayList<>();		
		expandList.add("sources");
		retrieveParams.put("expand", expandList);
		
		String stripeid = paymentserv.getStripeidbyiduser(userid);
		
		
		Customer customer = Customer.retrieve(stripeid,retrieveParams,null );
		
		//ajout de détails de la carte qui vont etre  passées dans le body de postman
		x.setNumber(x.getNumber());
		x.setExpMonth(x.getExpMonth());		
		x.setExpYear(x.getExpYear());
		x.setCvc(x.getCvc());
		System.out.println(x);
		
		//affectation de ces derniés détails dans le map
		Map<String,Object> cardetails = new HashMap<String, Object>(); 
		cardetails.put("number", x.getNumber());
		cardetails.put("exp_month", x.getExpMonth());
		cardetails.put("exp_year", x.getExpYear());
		cardetails.put("cvc", x.getCvc());
		
		//génération de token a partir de détails de la carte
		Map<String,Object> tokenparam = new HashMap<String, Object>(); 
		tokenparam.put("card", cardetails);
		Token token = Token.create(tokenparam);
		
		Map<String, Object> params = new HashMap<>();
		params.put("source", token.getId());

		Card card = (Card) customer.getSources().create(params);
	}
	
	
	@PostMapping(value = "/charger/{iduser}")	
	public void chargercustomer(HttpServletResponse response ,@RequestBody Charge charge , @PathVariable("iduser") int iduser )throws StripeException {
Stripe.apiKey="sk_test_51ITYUZKuxtPIEeD5lsPmKh2sG7jhzhhOpuBjXgXg4PL8cdjL79dL038v5SXcR32Ro9yIRxpfX6KfPQrQSxmR1h1p00xID5MdR4";
		
       
       String stripeid= paymentserv.getStripeidbyiduser(iduser);
       System.out.println(stripeid);

        Customer a = Customer.retrieve(stripeid);
        
      String subtype = sbr.getsubtype(iduser);
      System.out.println(subtype);
       
        if (subtype.equals("NORMAL"))
		{
        charge.setAmount(500L);
		}else if (subtype.equals("SURVEILLANCE"))
		{
	    charge.setAmount(1000L);
		}else if (subtype.equals("PREMIUM"))
		{
		charge.setAmount(1200L);
		}

        
		charge.setCurrency(charge.getCurrency());
		
		Map<String,Object> chargeparam = new HashMap<String, Object>(); 
		chargeparam.put("amount", charge.getAmount());
		chargeparam.put("currency", charge.getCurrency());
		chargeparam.put("customer", stripeid);
		Charge.create(chargeparam);
	}
	
	
	
	
	@PostMapping("/ActivateSubscription/{id}")
	@ResponseBody
	private int addSubsciption(@RequestBody Subscription subscription,@PathVariable("id") long userid)   
	{  
		String id = paymentserv.createCustomer(userrep.findById(userid).orElse(null));
		userrep.findById(userid).orElse(null).setIdStrype(id);
		userrep.save(userrep.findById(userid).orElse(null));
		
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
