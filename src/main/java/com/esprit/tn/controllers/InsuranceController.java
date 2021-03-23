package com.esprit.tn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.ContractType;
import com.esprit.tn.entities.Insurance;
import com.esprit.tn.services.InsuranceService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
	
	
	@Autowired
	InsuranceService insuranceserv;
	
	@PostMapping("/add")
	private Insurance addInsurance(@RequestBody Insurance insurance)   
	{  
		insuranceserv.addInsurance(insurance);  
		return insurance;  
	}
	
	@GetMapping("/show")  
	private List<Insurance> getAllInsurance()   
	{  
		return insuranceserv.getAllInsurance(); 
	}  
		
	
	@GetMapping("/getbyname/{insurance}")
	public Insurance getInsurance(@PathVariable String insurance) {
		Insurance c = insuranceserv.findByName(insurance);
				 return c;
		}

}
