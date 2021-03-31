package com.esprit.tn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Bank;
import com.esprit.tn.repositories.BankRepository;

@Service
public class BankServiceImpl implements IBankService{

	
	@Autowired
	private BankRepository iBankrep;
	
	@Override
    public void addBank(Bank b) {
        // TODO Auto-generated method stub
		iBankrep.save(b);
    }

	
	
	
	
	
	@Override
    public Bank updateBank(Bank b, int id) {
        // TODO Auto-generated method stub
        Bank Bank = iBankrep.findById(id).get();
        Bank.setName(b.getName());
       // Bank.setInterestrate(b.getInterestrate());
       
        iBankrep.save(Bank);
        return Bank;

    }

   

    
    @Override
    public List<Bank> getAllBanks() {
        // TODO Auto-generated method stub
        return (List<Bank>) iBankrep.findAll();
    }
    
    
    
    @Override
    public Bank getBankById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteBank(int id) {
        // TODO Auto-generated method stub
    	iBankrep.deleteById(id);

    }
   
    
}
