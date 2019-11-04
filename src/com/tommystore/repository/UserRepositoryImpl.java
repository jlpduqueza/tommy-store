package com.tommystore.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tommystore.bean.LoginBean;
import com.tommystore.constant.Role;
import com.tommystore.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User find(Integer id) {
		
		return em.find(User.class, id);
	}

	@Override
	public User save(User user) {
		
        if (user.getId() == null) {
            em.persist(user);
        } else {
            user = em.merge(user);
        }
        
        return user;
	}

	@Override
	public User validateLogin(LoginBean login) {
		
		try {
			TypedQuery<User> query =  em.createQuery("From User where email = :email AND password = :pass", User.class);
			query.setParameter("email", login.getEmail());
			query.setParameter("pass", login.getPassword());
			
	        return query.getSingleResult();
		} catch (NoResultException e) {
			
			return null;
		}
	}
	
	@Override
	public List<User> findUsers() {
		
		TypedQuery<User> query =  em.createQuery("From User", User.class);
		
		return query.getResultList();
	}

	@Override
	public List<User> viewNewUsers(Date range) {
		
		TypedQuery<User> query = em.createQuery("FROM User WHERE createDateTime >= :oneDayInterval", User.class);
		query.setParameter("oneDayInterval", range);
		
		return query.getResultList();
	}

	@Override
	public List<User> findUserByRole(Role role) {
		
		TypedQuery<User> query =  em.createQuery("From User where role=:role", User.class);
		query.setParameter("role", role);
		
		return query.getResultList();
	}

	@Override
	public Boolean isUserExistByEmail(String email) {
		
		TypedQuery<User> query =  em.createQuery("From User where email = :email", User.class);
		query.setParameter("email", email);
		
		try {
			query.getSingleResult();
			
			return true;
		} catch (NoResultException e) {
			
			return false;
		}
	}

	@Override
	public Boolean isValidToEdit(User user) {
		
		TypedQuery<User> query =  em.createQuery("From User where email = :email AND id != :id", User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("id", user.getId());
		
		try {
			query.getSingleResult();
			
			return false;
		} catch (NoResultException e) {
			
			return true;
		}
	}
	
}
