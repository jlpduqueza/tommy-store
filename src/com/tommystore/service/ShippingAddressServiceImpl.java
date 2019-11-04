package com.tommystore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommystore.constant.Country;
import com.tommystore.domain.ShippingAddress;
import com.tommystore.domain.User;
import com.tommystore.repository.ShippingAddressRepository;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{

	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	@Override
	@Transactional
	public ShippingAddress find(Integer id) {
		
		return shippingAddressRepository.find(id);
	}

	@Override
	@Transactional
	public ShippingAddress save(ShippingAddress shippingAddress) {
		
		return shippingAddressRepository.save(shippingAddress);
	}

	@Override
	@Transactional
	public List<ShippingAddress> findShippingAddresses() {
		
		return shippingAddressRepository.findShippingAddresses();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		shippingAddressRepository.delete(id);
	}

	@Override
	public List<Country> findCountries() {
		
    	List<Country> countryList = new ArrayList<>();
    	
    	for (Country country : Country.values()) {
    		countryList.add(country);
    	}
    	return countryList;
	}

	@Override
	@Transactional
	public List<ShippingAddress> findShippingAddresses(User user) {
		
		return shippingAddressRepository.findShippingAddressesByUser(user);
	}

}
