package com.cg.flp.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flp.entities.User;
import com.cg.flp.exception.UserException;
import com.cg.flp.repository.IUserRepository;
import com.cg.flp.service.IUserService;

@Service
@Transactional

public class UserService implements IUserService {
	
	@Autowired
	IUserRepository repository;
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/*
	@Override
	public User validateUser(String userName, String password) {

		User user = repository.validateUser(userName);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (encoder.matches(password, user.getPassword()))
			return user;
		else
			return null;
	}*/
	
	
	// Login in service
	@Override
	public User validateUser(String userName, String password) 
	{
		
		//String userName = user.getUserName();
		//String password = user.getPassword();
		
		User userData = repository.findByUserNameAndPassword(userName, password);
		if(userData==null) 
		{
			logger.error("User Not Found in SignIn method");
			throw new UserException("No user present");
		}
		else 
		{
			logger.error("User is present in SignIn method");
			return userData;
		}
		
	}

	
	/*@Override
	public User addUser(User user) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		User userData = repository.save(user);
		return userData;
	}
     */
	
	
	// Registration process
	@Override
	public User addUser(User user) {
		User newUser = repository.save(user);
		logger.info("*** Service :  User added successfully. ***");
		return newUser;
	}


}
	

