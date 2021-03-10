package com.esprit.tn.repositories;

import org.springframework.data.repository.CrudRepository;

import com.esprit.tn.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	public Role findByRoleName(String roleName); 

}
