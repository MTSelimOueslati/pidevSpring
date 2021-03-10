package com.esprit.tn.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.tn.entities.Role;
import com.esprit.tn.entities.User;
import com.esprit.tn.repositories.UserRepository;
import com.esprit.tn.services.UserService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserService userService;
    @Autowired
    UserRepository userRepository;

/*
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User User = userService.loadUserByUsername(username);
		if (User == null)
			throw new UsernameNotFoundException("invalid user");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Role r=User.getRole();
		authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		return new User();

	}*/
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        User user = userRepository.findUserByName(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return user;
    }
	
	


}
