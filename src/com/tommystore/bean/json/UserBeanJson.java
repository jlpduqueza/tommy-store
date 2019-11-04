package com.tommystore.bean.json;

import com.tommystore.domain.User;

public class UserBeanJson {

	private Integer id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String contactNumber;
	
	private String role;

	public UserBeanJson() {
		
	}
	
	public UserBeanJson(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.contactNumber = user.getContactNumber();
		this.role = user.getRole().toString();
	}

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getContactNumber() {
		return contactNumber;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	public String getRole() {
		return role;
	}

	
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
