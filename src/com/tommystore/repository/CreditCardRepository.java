package com.tommystore.repository;

import java.util.List;

import com.tommystore.domain.CreditCard;
import com.tommystore.domain.User;

public interface CreditCardRepository {

	public CreditCard find(Integer id);
	public CreditCard save(CreditCard creditCard);
	
	public void delete(Integer id);
	
	public List<CreditCard> getCreditCardList();
	public List<CreditCard> getCreditCardListByUser(User user);
	
}
