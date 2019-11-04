package com.tommystore.repository;

import java.util.List;

import com.tommystore.domain.ShippingAddress;
import com.tommystore.domain.User;

public interface ShippingAddressRepository {

	public ShippingAddress find(Integer id);
	public ShippingAddress save(ShippingAddress shippingAddress);
	
	public void delete(Integer id);
	
	public List<ShippingAddress> findShippingAddresses();
	public List<ShippingAddress> findShippingAddressesByUser(User user);
	
}

