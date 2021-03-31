package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.ContractType;

public interface IContractService {
	
	public Contract addContract(Contract c, int userid);

	public Contract updateContract(Contract c, int id);
	
	public void deleteContract(int id);
	
	public Contract getContractById(int id);
	
	public List<Contract> getAllContract();
	
	public List<Contract> findByType(ContractType type);
	
	


}
