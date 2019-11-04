package com.tommystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommystore.domain.CreditCard;
import com.tommystore.domain.User;
import com.tommystore.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	@Transactional
	public CreditCard find(Integer id) {
		
		return creditCardRepository.find(id);
	}

	@Override
	@Transactional
	public CreditCard save(CreditCard creditCard) {
		
		return creditCardRepository.save(creditCard);
	}

	@Override
	@Transactional
	public List<CreditCard> findCreditCards() {
		
		return creditCardRepository.getCreditCardList();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		creditCardRepository.delete(id);
	}

	@Override
	@Transactional
	public List<CreditCard> findCreditCardsByUser(User user) {
		
		return creditCardRepository.getCreditCardListByUser(user);
	}

}
