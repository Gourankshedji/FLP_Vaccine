package com.cg.flp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flp.entities.User;
import com.cg.flp.exception.UserException;
import com.cg.flp.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/covidVaccination/users")

public class UserController {

	@Autowired
	IUserService service;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// Method to add user details (Registration)
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User userData = service.addUser(user);
		if (userData == null) {
			logger.error("Controller: Failed to add user");
			throw new UserException("User not added");
		}
		logger.info("*** Controller : User added successfully. ***");
		return new ResponseEntity<User>(userData, HttpStatus.OK);
	}
	
	
	// Method to user login by userName and password
	@GetMapping("/validateUser")
	public ResponseEntity<User> validateUser(String userName, String password) {

		
		User userData = service.validateUser(userName, password);
		if (userData == null) {
			logger.error("*** Controller : Invalid Credentials ***");
			throw new UserException("Invalid Credentials");
		}
		logger.info("*** Controller : Successfull Login ***");
		return new ResponseEntity<User>(userData, HttpStatus.OK);

	}
	
	// Method to view all user
	/*@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		logger.info("Inside getAllUser method");
		List<User> userList = service.getAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}*/
}
