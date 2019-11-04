package com.tommystore.bean;

import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	
	@NotBlank(message="Invalid email")
	private String email;

	@NotBlank(message="Invalid password")
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", password=" + password + "]";
	}
	
}
