package com.esprit.tn.services;

import java.util.List;

import com.esprit.tn.entities.Subscription;

public interface ISubscriptionService {
	public void ActivateSubscription(Subscription sub, long userid);
	public List<Subscription> getAllSubscriptions();
	public Subscription getSubscriptionById(int id);
	public Subscription updateSubscription(Subscription s , int id);
	public List<Subscription> filterSub(String type);

}
