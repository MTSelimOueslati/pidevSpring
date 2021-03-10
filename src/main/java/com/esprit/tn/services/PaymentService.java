package com.esprit.tn.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.esprit.tn.entities.User;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;


@Service("paymentService")
public class PaymentService implements IPaymentService {

	 private static final String TEST_STRIPE_SECRET_KEY = "sk_test_51ITYUZKuxtPIEeD5lsPmKh2sG7jhzhhOpuBjXgXg4PL8cdjL79dL038v5SXcR32Ro9yIRxpfX6KfPQrQSxmR1h1p00xID5MdR4";
	
	 public PaymentService() {
		    Stripe.apiKey = TEST_STRIPE_SECRET_KEY;
		  }
	 
	@Override
	public String createCustomer(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> customerParams = new HashMap<String, Object>();
	    customerParams.put("description", 
	      user.getName() );
		customerParams.put("email", user.getEmail());
		System.out.println("user.getEmail()");	
		String id = null;
		try { 
	      // Create customer
		  Customer stripeCustomer = Customer.create(customerParams);
		  id = stripeCustomer.getId();
		  System.out.println(stripeCustomer);
		} catch (CardException e) {
		  // Transaction failure
		} catch (RateLimitException e) {
		  // Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
		  // Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
		  // Authentication with Stripe's API failed (wrong API key?)
		} catch (APIConnectionException e) {
		  // Network communication with Stripe failed
		} catch (StripeException e) {
		  // Generic error
		} catch (Exception e) {
		// Something else happened unrelated to Stripe
		}
		
	    return id;	
		
	}

}
