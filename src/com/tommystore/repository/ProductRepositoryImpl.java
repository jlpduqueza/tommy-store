package com.tommystore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.tommystore.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Product find(Integer id) {
		
		return em.find(Product.class, id);
	}

	@Override
	public Product save(Product product) {
		
        if (product.getId() == null) {
        	em.persist(product);
        	
        } else {
            product = em.merge(product);
        }
        
        return product;
	}

	@Override
	public List<Product> findProducts() {
		
		TypedQuery<Product> query =  em.createQuery("From Product", Product.class);
		
		return query.getResultList();
	}

	@Override
	public void delete(Integer id) {
		
		em.remove(em.find(Product.class, id).getInventoryItem());
		em.remove(em.find(Product.class, id));
	}

	@Override
	public Boolean isExistByNameAndCategoryId(String name, Integer id) {
		
		TypedQuery<Product> query =  em.createQuery("From Product where name = :name AND category.id = :id", Product.class);
		query.setParameter("name", name);
		query.setParameter("id", id);
		
		try {
			query.getSingleResult();
			
			return true;
		} catch (NoResultException e) {
			
			return false;
		}
	}

	@Override
	public List<Product> findProductByCategoryId(Integer id) {
		
		TypedQuery<Product> query =  em.createQuery("From Product where category.id = :id", Product.class);
		query.setParameter("id", id);
			
		return query.getResultList();
	}

	@Override
	public Boolean isNameValid(String name, Integer id) {
		
		TypedQuery<Product> query =  em.createQuery("From Product where name = :name AND id != :id", Product.class);
		query.setParameter("name", name);
		query.setParameter("id", id);
		
		try {
			query.getSingleResult();
			
			return true;
		} catch (NoResultException e) {
			
			return false;
		}
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		
		TypedQuery<Product> query =  em.createQuery("from Product where name like :keyword or category.name like :keyword", Product.class);
		query.setParameter("keyword", "%"+keyword+"%");
		
		return query.getResultList();
	}

	@Override
	public List<Product> searchProductByCategory(String keyword) {
		
		TypedQuery<Product> query =  em.createQuery("from Product where category.name like :keyword", Product.class);
		query.setParameter("keyword", "%"+keyword+"%");
		
		return query.getResultList();
	}

	@Override
	public List<Product> searchProductByName(String keyword) {
		
		TypedQuery<Product> query =  em.createQuery("from Product where name like :keyword", Product.class);
		query.setParameter("keyword", "%"+keyword+"%");
		
		return query.getResultList();
	}

	@Override
	public Boolean isExistByPicture(MultipartFile file) {
		
		TypedQuery<Product> query =  em.createQuery("From Product where picturePath = :fileName", Product.class);
		query.setParameter("fileName", file.getOriginalFilename());
		
		try {
			query.getSingleResult();
			
			return true;
		} catch (NoResultException e) {
			
			return false;
		}
	}


}
