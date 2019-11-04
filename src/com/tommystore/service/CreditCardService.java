package com.tommystore.service;

import java.util.List;

import com.tommystore.domain.CreditCard;
import com.tommystore.domain.User;

public interface CreditCardService {

	public CreditCard find(Integer id);
	public CreditCard save(CreditCard creditCard);
	
	public void delete(Integer id);
	
	public List<CreditCard> findCreditCards();
	public List<CreditCard> findCreditCardsByUser(User user);
	
}
