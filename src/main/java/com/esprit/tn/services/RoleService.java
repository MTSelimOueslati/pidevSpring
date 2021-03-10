package com.esprit.tn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.tn.entities.Role;
import com.esprit.tn.repositories.RoleRepository;

@Service
public class RoleService implements IRoleService{
	
	
	
	@Autowired
	RoleRepository roleRep;
	
	@Override
	public Role addRole(Role role) {
		roleRep.save(role);
		return role;
	}


}
