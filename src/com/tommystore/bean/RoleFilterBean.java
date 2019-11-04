package com.tommystore.bean;


import org.hibernate.validator.constraints.NotBlank;

public class RoleFilterBean {

	@NotBlank
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
