package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Contract;
import com.esprit.tn.entities.Insurance;

public interface IInsuranceService {
	public Insurance addInsurance(Insurance i);

	
	public List<Insurance> getAllInsurance();
	
	public Insurance findByName(String insurance);

}
