package com.esprit.tn.services;

import java.util.HashMap;
import java.util.List;


import com.esprit.tn.entities.Offer;

public interface IOfferService {
	
	public void addOffer(Offer o);
	public List<Offer> getAllOffers();
	public void deleteOffer(int id);
	public Offer updateOffer(Offer o, int id);
	public Offer  test(int id, float salary);
	public Offer getOffer(int id);
	public float calcul(int id,float salary,float price);
	public float Paiment(int id);
	public float loanAmont(int id,float nbm );
	public float nbmonths(int id, float amont);
	public float monthlypayment(int id, float amont, float nbm  );
	public Offer UserCount(int id);
	public List<Offer> BestOffers();
	public int Sum();
	public HashMap<String, String> Percentage();  
	
}
