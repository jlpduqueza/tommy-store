package com.tommystore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tommystore.domain.CreditCard;
import com.tommystore.domain.User;

@Repository
public class CreditCardRepositoryImpl implements CreditCardRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CreditCard find(Integer id) {
		
		return em.find(CreditCard.class, id);
	}

	@Override
	public CreditCard save(CreditCard creditCard) {
       
		if (creditCard.getId() == null) {
	        em.persist(creditCard);
        } else {
            creditCard = em.merge(creditCard);
        }
       
		return creditCard;
	}

	@Override
	public List<CreditCard> getCreditCardList() {
		
		TypedQuery<CreditCard> query =  em.createQuery("From CreditCard", CreditCard.class);
		
		return query.getResultList();
	}

	@Override
	public void delete(Integer id) {
		
		em.remove(em.find(CreditCard.class, id));
	}

	@Override
	public List<CreditCard> getCreditCardListByUser(User user) {
		
		TypedQuery<CreditCard> query =  em.createQuery("From CreditCard where user.id = :id", CreditCard.class);
		query.setParameter("id", user.getId());
		
		return query.getResultList();
	}

}
