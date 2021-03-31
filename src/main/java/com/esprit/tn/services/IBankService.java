package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Bank;

public interface IBankService {
  
	public void addBank(Bank b);
    public Bank updateBank(Bank b, int id);
    public List<Bank> getAllBanks();
    public Bank getBankById(int id);
    public void deleteBank(int id);
    
	
}
