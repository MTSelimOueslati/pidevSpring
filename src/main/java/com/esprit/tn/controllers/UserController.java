package com.esprit.tn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.ConfirmationToken;
import com.esprit.tn.entities.Role;
import com.esprit.tn.entities.User;
import com.esprit.tn.entities.util.UserForm;
import com.esprit.tn.repositories.ConfirmationTokenRepository;
import com.esprit.tn.repositories.UserRepository;
import com.esprit.tn.services.RoleService;
import com.esprit.tn.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userservice;

	@Autowired
	RoleService roleservice;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	private UserRepository userRep;
	

	@PostMapping("/Signup")
	public User register(@RequestBody UserForm a) {
		User user = userservice.addSimpleUser(a);
		ConfirmationToken confirmationToken = new ConfirmationToken(user);

		confirmationTokenRepository.save(confirmationToken);
		/*SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(appUser.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom("daritn2021@gmail.com");
		mailMessage.setText("To confirm your account, please click here : "
				+ "http://localhost:8081/api/confirm-account?token=" + confirmationToken.getConfirmationToken());
		emailSenderService.sendEmail(mailMessage);*/
		return user;
	}


	/*@PostMapping("confirm-account")
	public void confirmUserAccount(@RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userRep.findUserByName(token.getUser().getName());
			UserForm af = new UserForm();
			af.setEmail(user.getEmail());
			af.setVerified(true);
			UserService.updateUser(af);
		}

	}*/

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role r) 
	{
		roleservice.addRole(r);
		return r;
	}


	@PostMapping("/addAdmin")
	public User addAdmin(@RequestBody User a) {
		User user1 = userservice.addAdmin(a);
		ConfirmationToken confirmationToken = new ConfirmationToken(user1);
		confirmationTokenRepository.save(confirmationToken);
		return user1;
	}
	

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userservice.deleteUser(id);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody UserForm user) {
		return userservice.updateUser(user);
	}
	
	
	
	
}
