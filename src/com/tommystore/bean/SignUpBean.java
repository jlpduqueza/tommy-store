package com.tommystore.bean;

import org.hibernate.validator.constraints.NotBlank;

public class SignUpBean {
	
	@NotBlank(message="Enter email")
	private String email;
	
	@NotBlank(message="Enter a password")
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank(message="Enter first name")
	private String firstName;
	
	@NotBlank(message="Enter last name")
	private String lastName;
	
	private String contactNumber;
	
	private String role;
	
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
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "SignUpBean [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber=" + contactNumber + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
