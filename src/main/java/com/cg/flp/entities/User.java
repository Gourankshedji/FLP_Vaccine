package com.cg.flp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Declare the class a entity
@Entity

//Declare the table name
@Table(name="users")
public class User {

	//attributes
	@Id
	@GeneratedValue // generates an automatic value during commit for every new entity
	private int userId;
	
	@NotEmpty(message="User name is required")
	private String userName;
	
	@NotEmpty(message="User contact is required")
	@Pattern(regexp = "\\d{10}", message ="Contact number is Invalid")	
	private String contact;
	
	@NotEmpty(message="Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+[@][a-zA-Z]+[.][a-zA-Z]+", message="Email id is invalid")
	private String emailId;
	
	@NotEmpty(message = "Password must not be empty")
	@Size(min=8, max=20, message="Password should be between 2 and 8 characters")
	@Pattern(regexp="^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20}", 
	 message="Password must contain atleast one upper case, one lower case a digit and a special character")
	private String password;
	
	
	//default constructor
	public User() {
		super();
	}

	//constructor without id
	public User(String userName, String contact, String emailId, String password) {
		super();
		this.userName = userName;
		this.contact = contact;
		this.emailId = emailId;
		this.password = password;
	}


	//constructor with id
	public User(int userId, String userName, String contact, String emailId, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.contact = contact;
		this.emailId = emailId;
		this.password = password;
	}


	//setter getter methods
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", contact=" + contact + ", emailId=" + emailId
				+ ", password=" + password + "]";
	}	
}
