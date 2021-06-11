package com.cg.flp.service;

import com.cg.flp.entities.User;

public interface IUserService {

	public User validateUser(String username, String password);
	public User addUser(User user);
}
