package com.esprit.tn.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.tn.entities.Offer;

import com.esprit.tn.repositories.OfferRepository;
import com.jayway.jsonpath.internal.function.text.Concatenate;




@Service
public class OfferServiceImpl implements IOfferService {
	
	

	@Autowired
	private OfferRepository iOfferrep;
	
	
	@Override
	public void addOffer(Offer o) {
		// TODO Auto-generated method stub
		iOfferrep.save(o);
		
	}
	
	
	@Override
	public List<Offer> getAllOffers() {
		// TODO Auto-generated method stub
		return (List<Offer>) iOfferrep.findAll();
	}
	
	
	public List<Offer> BestOffers() {
		// TODO Auto-generated method stub
		return (List<Offer>) iOfferrep.findAllByOrderByNmbDesc();
	}
	
	
	@Override
	public void deleteOffer(int id) {
		// TODO Auto-generated method stub
		iOfferrep.deleteById(id);
	}
	
	@Override
	public Offer updateOffer(Offer o, int id) {
		// TODO Auto-generated method stub
		Offer Offer = iOfferrep.findById(id).get();
		Offer.setDescription(o.getDescription());
		Offer.setIntrestRate(o.getIntrestRate());
		Offer.setTex(o.getTex());
		Offer.setSalaireMin(o.getSalaireMin());
		Offer.setNmbUsers(o.getNmb());
		
		//Offer.setNmbUsers(Offer.getNmbUsers()+1);
		iOfferrep.save(o);
		return Offer;
	}

	

	
	@Override
	public Offer UserCount(int id) {
		// TODO Auto-generated method stub
		Offer Offer = iOfferrep.findById(id).get();
		/*int a=offer.getNmbUsers();
		
		a=a+1;
		offer.setNmbUsers(a);*/
		
		Offer.setNmbUsers(Offer.getNmb()+1);
		
		iOfferrep.save(Offer);
		return Offer;
	}
	
	
	@Override
	public Offer getOffer(int id) {
		// TODO Auto-generated method stub
		Offer Offer = iOfferrep.findById(id).get();

		return Offer;
	}
	
	
	
	
	
	
	
	
	public Offer test(int id, float salary) {
		// TODO Auto-generated method stub
		float a;
		Offer offer = iOfferrep.findById(id).get();
		 

		a=offer.getSalaireMin();
		
		if (salary*0.4<a) 
		{
			throw new RuntimeException("You can't have this loan :( ");
			
			
		}
		else {
				return getOffer(id);
			} 
		
	}
	

	public float calcul(int id, float salary, float price) {
		// TODO Auto-generated method stub
		float total;
		Offer offer = iOfferrep.findById(id).get();
		float IR=offer.getIntrestRate();
		float tax=offer.getTex();
		total=salary+price+IR;
		return total;
	}
	
	
	
	public float Paiment(int id)
	{
		float payment;
		Offer offer = iOfferrep.findById(id).get();
		payment=offer.getSalaireMin()*40;
		payment=payment/100;
		return payment;
		
	}
	
	
	
	public float loanAmont(int id,float nbm) {
		// TODO Auto-generated method stub
		Offer offer = iOfferrep.findById(id).get();
		float PV ;
		float PMT=offer.getSalaireMin();
		float i=offer.getIntrestRate();
		float a=PMT/i;
		float b=(float)Math.pow(i+1,nbm);
		float c=1/b;
		float d=1-c;
		PV=a*d;
		return PV;
	}
	
	
	public float nbmonths(int id, float amont) {
		// TODO Auto-generated method stub
		Offer offer = iOfferrep.findById(id).get();
		float nbm;
		float PMT=offer.getSalaireMin();
		float i=offer.getIntrestRate();
		float a=PMT/i;
		float b=a-amont;
		float c=(float)Math.log(a/b);
		float d=(float)Math.log(1+i);
		nbm=c/d;
		return nbm;
	}
	
	
	public float monthlypayment(int id, float amont, float nbm) {
		// TODO Auto-generated method stub
		Offer offer = iOfferrep.findById(id).get();
		float i=offer.getIntrestRate();
		float a=(float)Math.pow(1+i,nbm);
		float b=amont*i*a;
		float c=a-1;
		float PMT=b/c;
		return PMT;
	}
	@Override
	public int Sum() {
		// TODO Auto-generated method stub
		return  iOfferrep.sumNmbAmount();
	}
	
	public HashMap<String, String> Percentage() {
		// TODO Auto-generated method stub
		int N;
		int M;
		float Z;
		String ch;
		String ch2="%";
		String ch3;
		N=iOfferrep.MAX();
		M=iOfferrep.sumNmbAmount();
		HashMap<String, String> percen = new HashMap<String, String>();
		Offer offer ;
		int a;
		for (int i = 2; i < N+1; i++) {
			 offer = iOfferrep.findById(i).get(); 
			 a=offer.getNmb();
			 if (a>0)
			{
				 
				 Z=(float)a/M;
				 Z=Z*100;
				 ch=String.valueOf(Z);
				 ch3=ch+ch2;
				 percen.put(offer.getDescription(),ch3);
			}
			 else 
			 {
				 percen.put(offer.getDescription(),"no user has chosen this offer");
			 }
			}
		return percen;
	}  
}


