package com.esprit.tn.services;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.ConfirmationToken;
import com.esprit.tn.entities.Role;
import com.esprit.tn.entities.User;
import com.esprit.tn.entities.util.UserForm;
import com.esprit.tn.repositories.ConfirmationTokenRepository;
import com.esprit.tn.repositories.RoleRepository;
import com.esprit.tn.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService, IUserService {

	@Autowired
     UserRepository userRep;
	
	@Autowired
    RoleRepository roleRep;
	
	@Autowired
	ConfirmationTokenRepository confRep;
    
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRep = userRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = userRep.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
    
    
    
    @Override
    public User addSimpleUser(UserForm a) {
		//if (userRep.findUserByName(a.getName()) != null)
			//throw new RuntimeException("User already exists");
		Role r = roleRep.findByRoleName("SIMPLE_USER");
		User user = new User();
		if (a.getAddress() != null) {
			user.setAddress(a.getAddress());
		}
		if (a.getEmail() != null) {
			user.setEmail(a.getEmail());
		}
		if (a.getName() != null) {
			user.setName(a.getName());
		}
		if (a.getPassword() != null) {
			user.setPassword(bCryptPasswordEncoder.encode(a.getPassword()));
		}
		if (a.getPhone_number() != 0) {
			user.setPhone_number(a.getPhone_number());
		}
		user.setVerified(false);
		ArrayList<Role> roles = new ArrayList<Role>();
		roles.add(r);
		user.setRole(r);
		userRep.save(user);
		return user;
	}
    
    
    @Override
	public User addAdmin(User a) {
		/*if (userRep.findUserByName(a.getName())!= null)
			throw new RuntimeException("User already exists");*/
		Role r = roleRep.findByRoleName("ADMIN");
		User user = new User();
		if (a.getAddress() != null) {
			user.setAddress(a.getAddress());
		}
		if (a.getEmail() != null) {
			user.setEmail(a.getEmail());
		}
		if (a.getName() != null) {
			user.setName(a.getName());
		}
		if (a.getPassword() != null) {
			user.setPassword(bCryptPasswordEncoder.encode(a.getPassword()));
		}
		if (a.getPhone_number() != 0) {
			user.setPhone_number(a.getPhone_number());
		}
		user.setVerified(false);
		user.setRole(r);
		String pwd = bCryptPasswordEncoder.encode(a.getPassword());
		a.setPassword(pwd);
		userRep.save(user);
		return user;
	}

    @Override
	public void deleteUser(int id) {
		User user = userRep.findByUserId(id);
		if (user == null)
			throw new RuntimeException("User doesn't exists");
		user.setRole(null);
		userRep.save(user);
		ConfirmationToken conf = confRep.findByUser(user);
		confRep.delete(conf);
		userRep.delete(user);

	}
    
    @Override
	public User updateUser(UserForm a) {
		User user = userRep.findByName(a.getName());
		if (user == null)
			throw new RuntimeException("User doesn't exists");
		if (a.getAddress() != null) {
			user.setAddress(a.getAddress());
		}
		if (a.getEmail() != null) {
			user.setEmail(a.getEmail());
		}
		if (a.getName() != null) {
			user.setName(a.getName());
		}
		if (a.getPassword() != null) {
			user.setPassword(bCryptPasswordEncoder.encode(a.getPassword()));
		}
		if (a.getPhone_number() != 0) {
			user.setPhone_number(a.getPhone_number());
		}
		if (a.isVerified()) {
			user.setVerified(true);
		}

		userRep.save(user);
		return user;
	}

    
}
