package com.esprit.tn.services;

import com.esprit.tn.entities.User;
import com.esprit.tn.entities.util.UserForm;

public interface IUserService {
    public User addSimpleUser(UserForm a);

	User addAdmin(User a);
	
	public void deleteUser(long id);
	
	public User updateUser(UserForm a);




}
