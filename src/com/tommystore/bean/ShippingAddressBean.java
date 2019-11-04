package com.tommystore.bean;

import org.hibernate.validator.constraints.NotBlank;

public class ShippingAddressBean {

	@NotBlank
	private String address1;

	@NotBlank
	private String address2;
	
	@NotBlank
	private String zipCode;
	
	@NotBlank
	private String country;
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
