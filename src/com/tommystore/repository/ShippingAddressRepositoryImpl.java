package com.tommystore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tommystore.domain.ShippingAddress;
import com.tommystore.domain.User;

@Repository
public class ShippingAddressRepositoryImpl implements ShippingAddressRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public ShippingAddress find(Integer id) {
		
		return em.find(ShippingAddress.class, id);
	}

	@Override
	public ShippingAddress save(ShippingAddress shippingAddress) {
		
        if (shippingAddress.getId() == null) {
	        em.persist(shippingAddress);
        } else {
            shippingAddress = em.merge(shippingAddress);
        }
        
        return shippingAddress;
	}

	@Override
	public List<ShippingAddress> findShippingAddresses() {
		
		TypedQuery<ShippingAddress> query =  em.createQuery("From ShippingAddress", ShippingAddress.class);
		
		return query.getResultList();
	}

	@Override
	public void delete(Integer id) {
		
		em.remove(em.find(ShippingAddress.class, id));
	}

	@Override
	public List<ShippingAddress> findShippingAddressesByUser(User user) {
		
		TypedQuery<ShippingAddress> query =  em.createQuery("From ShippingAddress where user.id = :id", ShippingAddress.class);
		query.setParameter("id", user.getId());
		
		return query.getResultList();
	}

}
