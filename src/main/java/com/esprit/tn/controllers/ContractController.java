package com.esprit.tn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.ContractType;
import com.esprit.tn.services.ContractService;

@RestController
@RequestMapping("/contract")
public class ContractController {
	
	@Autowired
	ContractService contractservice;
	
	
	
	@PostMapping("/add/{id}")
	private Contract addContract(@RequestBody Contract contract, @PathVariable("id")int id)   
	{  
		contractservice.addContract(contract,id);  
		
		return contract;  
	}  
	
	
	@PutMapping("/update/{id}")
	private Contract updateContract(@RequestBody Contract contract, @PathVariable("id")int id)   
	{  
		contractservice.updateContract(contract, id);
		return contract;  
	}
	
	@GetMapping("/show")  
	private List<Contract> getAllContract()   
	{  
		return contractservice.getAllContract(); 
	}  
	
	
	@GetMapping("/getbytype/{type}")
	public List<Contract> getContractByType(@PathVariable ContractType type) {
		List<Contract> c = contractservice.findByType(type);
				 return c;
		}

}
