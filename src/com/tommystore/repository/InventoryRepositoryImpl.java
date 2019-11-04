package com.tommystore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.StockHistory;
import com.tommystore.domain.User;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public InventoryItem find(Integer id) {
		
		return em.find(InventoryItem.class, id);
	}

	@Override
	public InventoryItem save(InventoryItem inventoryItem, User user) {
		
        if (inventoryItem.getId() == null) {
	        em.persist(inventoryItem);
        } else {
            inventoryItem = em.merge(inventoryItem);
            //note put this to save stock history
            StockHistory stockHistory = new StockHistory();
            stockHistory.setInventoryItem(inventoryItem);
            stockHistory.setUser(user);
            stockHistory.setUpdatedQuantity(inventoryItem.getQuantity());
            em.persist(stockHistory);
        }
        
        return inventoryItem;
	}

	@Override
	public List<InventoryItem> findInventoryItems() {
		
		TypedQuery<InventoryItem> query =  em.createQuery("From InventoryItem", InventoryItem.class);
		
		return query.getResultList();
	}

	@Override
	public List<InventoryItem> findByStock(int stock) {
		
		TypedQuery<InventoryItem> query =  em.createQuery("From InventoryItem where quantity <= :nStock", InventoryItem.class);
		query.setParameter("nStock", stock);
		
		return query.getResultList();
	}

	@Override
	public InventoryItem findByProductId(Integer id) {
		
		TypedQuery<InventoryItem> query =  em.createQuery("From InventoryItem where product.id = :id", InventoryItem.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public List<StockHistory> findStockHistories(Integer id) {
		
		TypedQuery<StockHistory> query =  em.createQuery("From StockHistory where inventoryItem.id = :id", StockHistory.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

}
