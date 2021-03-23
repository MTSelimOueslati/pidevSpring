package com.esprit.tn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.Insurance;
import com.esprit.tn.repositories.InsuranceRepository;

@Service
public class InsuranceService implements IInsuranceService {

	
	@Autowired
	InsuranceRepository insurancerepo;
	
	@Override
	public Insurance addInsurance(Insurance i) {
		// TODO Auto-generated method stub
		insurancerepo.save(i);
		return i;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		// TODO Auto-generated method stub
		List<Insurance>insurances = new ArrayList<Insurance>();
		insurancerepo.findAll().forEach(i ->insurances.add(i));
		return insurances;
	}

	@Override
	public Insurance findByName(String insurance) {
		// TODO Auto-generated method stub
		Insurance ins = insurancerepo.findByName(insurance);
		return ins;
	}

}
