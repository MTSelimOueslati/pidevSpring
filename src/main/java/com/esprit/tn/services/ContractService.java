package com.esprit.tn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.ContractType;
import com.esprit.tn.entities.User;
import com.esprit.tn.repositories.ContractRepository;
import com.esprit.tn.repositories.UserRepository;

@Service
public class ContractService implements IContractService {
	
	@Autowired
	ContractRepository contractrepo;
	
	@Autowired
	UserRepository userrep;

	
	@Override
	public Contract addContract(Contract c, int userid){
		// TODO Auto-generated method stub
		User user = userrep.findByUserId(userid);
		c.setUser(user);
		contractrepo.save(c);
		return c;
	}
	
	

	@Override
	public Contract updateContract(Contract c, int id) {
		// TODO Auto-generated method stub
		Contract con = contractrepo.findById(id).get();
		con.setAddress(c.getAddress());
		con.setBuyer(c.getBuyer());
		con.setType(c.getType());
		con.setDate(c.getDate());
		con.setSeller(c.getSeller());
		con.setSum(c.getSum());
		return con;
	}

	@Override
	public void deleteContract(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contract getContractById(int id) {
		// TODO Auto-generated method stub
		return contractrepo.findById(id).get();
	}

	@Override
	public List<Contract> getAllContract() {
		// TODO Auto-generated method stub
		List<Contract>contracts = new ArrayList<Contract>();
		contractrepo.findAll().forEach(d ->contracts.add(d));
		return contracts;
	}
	
	
	@Override
	public List<Contract> findByType(ContractType type) {
		return contractrepo.findByType(type);
	}

}
