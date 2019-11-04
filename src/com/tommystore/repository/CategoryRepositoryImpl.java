package com.tommystore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tommystore.domain.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Category find(Integer id) {
		
		return em.find(Category.class, id);
	}

	@Override
	public Category save(Category category) {
		
        if (category.getId() == null) {
	        em.persist(category);
        } else {
            category = em.merge(category);
        }
        
        return category;
	}

	@Override
	public List<Category> findCategories() {
		
		TypedQuery<Category> query =  em.createQuery("From Category", Category.class);
		
		return query.getResultList();
	}

	@Override
	public List<Category> getCategoryList() {
		
		TypedQuery<Category> query =  em.createQuery("From Category", Category.class);
		
		return query.getResultList();
	}

	@Override
	public void delete(Integer id) {
		
		em.remove(em.find(Category.class, id));
	}

	@Override
	public Boolean isCategoryExistByName(String name) {
		
		TypedQuery<Category> query =  em.createQuery("From Category where name = :name", Category.class);
		query.setParameter("name", name);
		
		try {
			query.getSingleResult();
			
			return true;
		} catch (NoResultException e) {
			
			return false;
		}
	}

	@Override
	public Boolean isValidCategoryName(Integer id, String name) {
	
		TypedQuery<Category> query =  em.createQuery("From Category where name = :name AND id != :id", Category.class);
		query.setParameter("name", name);
		query.setParameter("id", id);
		
		try {
			query.getSingleResult();
			
			return false;
		} catch (NoResultException e) {
			
			return true;
		}
	}

}
