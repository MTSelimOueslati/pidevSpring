package com.esprit.tn.services;

import java.time.Instant;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Subscription;
import com.esprit.tn.entities.User;
import com.esprit.tn.repositories.SubscriptionRepository;
import com.esprit.tn.repositories.UserRepository;


@Service
public class SubscriptionService implements ISubscriptionService {
	@Autowired
	private SubscriptionRepository subrepo;
	
	@Autowired
	private UserRepository userrep;

	@Override
	public void ActivateSubscription(Subscription sub, int userid) {
		// TODO Auto-generated method stub
		User user=userrep.findByUserId(userid);
		user.setSubscribed(true);
		userrep.save(user);
		sub.setStartDate(Date.from(Instant.now()));
		Date endDate = Date.from(Instant.now().plus(Period.ofDays(30)));
		sub.setEndDate(endDate);
		sub.setSubtype("Premium");
		subrepo.save(sub);
		
	}

	@Override
	public List<Subscription> getAllSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription getSubscriptionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription updateSubscription(Subscription s, int id) {
		// TODO Auto-generated method stub
		Subscription sub = subrepo.findById(id).get();
		s.setEndDate(sub.getEndDate());
		return subrepo.save(s);	}

	@Override
	public List<Subscription> filterSub(String type) {
		// TODO Auto-generated method stub
		return null;
	}
}
