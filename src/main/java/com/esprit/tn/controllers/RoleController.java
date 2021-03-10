package com.esprit.tn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.tn.entities.Role;
import com.esprit.tn.services.RoleService;


@RestController
@RequestMapping()

public class RoleController {
	
	@Autowired
	RoleService roleservice;
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role r) 
	{
		roleservice.addRole(r);
		return r;
	}

}
