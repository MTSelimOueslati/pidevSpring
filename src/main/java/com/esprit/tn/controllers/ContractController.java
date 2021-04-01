package com.esprit.tn.controllers;




import org.dom4j.DocumentException;
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
import com.esprit.tn.repositories.ContractRepository;
import com.esprit.tn.repositories.UserRepository;
import com.esprit.tn.services.ContractService;

import java.util.Date;
import java.util.List;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/contract")
public class ContractController {
	
	@Autowired
	ContractService contractservice;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	ContractRepository contractrepo;
	
	@PostMapping("/add/{id}")
	private Contract addContract(@RequestBody Contract contract, @PathVariable("id")int id)   
	{  
		contractservice.addContract(contract,id);  
		
		return contract;  
	}  
	
	@GetMapping("/download")
	private void download (HttpServletResponse response) throws DocumentException, IOException{
		
		response.setContentType("application/pdf");
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Contract__"  +"__"+currentDateTime+ ".pdf";
	    response.setHeader(headerKey, headerValue);
	   // List<Contract> contract=  contractrepo.getContract(user_id);
	    List<Contract> contract = contractservice.getAllContract();
	    UserPDFExporter exporter = new UserPDFExporter(contract);
		 exporter.export(response);
		
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
