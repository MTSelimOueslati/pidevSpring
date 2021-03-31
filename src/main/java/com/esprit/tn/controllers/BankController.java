package com.esprit.tn.controllers;

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
import com.esprit.tn.services.BankServiceImpl;

@RestController
public class BankController {
	
	
	@Autowired
	    BankServiceImpl bankservimpl;

	    //add Bank
	    @PostMapping("/bank/add-bank")
	    @ResponseBody
	    private Bank addBank(@RequestBody Bank bank)
	    {
	        bankservimpl.addBank(bank); 
	        return bank;
	    }
	

	    
	    @PutMapping("/bank/update/{id}")      
	    private Bank updateBank(@RequestBody Bank bank, @PathVariable("id")int id )
	    {        
	    	bankservimpl.updateBank(bank, id); 
	    return bankservimpl.updateBank(bank, id);    
	    }
	    
	    
	    
	    @DeleteMapping("bank/delete/{id}")
	    public void deleteBankById(@PathVariable("id") int id) {
	        bankservimpl.deleteBank(id);
	    }
	    
	    
	    
	    @GetMapping("bank/getAll")
	    public List<Bank> getAllBanks() {
	        return bankservimpl.getAllBanks();
	    }
	    
	    
	    
	    
	    /*    //show  all Banks 
	   @GetMapping("/bank/get-all-banks/")
	   private List<Bank> getAllBanks()   
		{  
			return bankservimpl.getAllBanks();  
		}  
	    */
	  


}


