package com.tommystore.service;

import java.util.List;

import com.tommystore.constant.Country;
import com.tommystore.domain.ShippingAddress;
import com.tommystore.domain.User;

public interface ShippingAddressService {

	public ShippingAddress find(Integer id);
	public ShippingAddress save(ShippingAddress shippingAddress);
	
	public void delete(Integer id);
	
	public List<Country> findCountries();
	public List<ShippingAddress> findShippingAddresses();
	public List<ShippingAddress> findShippingAddresses(User user);
	
}

