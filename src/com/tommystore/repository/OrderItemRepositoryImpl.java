package com.tommystore.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tommystore.domain.Cart;
import com.tommystore.domain.CartItem;
import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.Order;
import com.tommystore.domain.OrderItem;
import com.tommystore.domain.Product;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<OrderItem> findOrderItemsProductId(Integer id) {
		
		TypedQuery<OrderItem> query =  em.createQuery("From OrderItem where product.id = :id order by order.purchaseDate DESC", OrderItem.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

	@Override
	public List<Product> findPopularProducts(Date range) {
		
		TypedQuery<Product> query =  em.createQuery("select p From OrderItem o JOIN o.product p WHERE o.order.purchaseDate >= :oneMonthInterval group by product_id order by sum(o.quantity) DESC", Product.class);
		query.setParameter("oneMonthInterval", range);
		query.setMaxResults(12);
		
		return query.getResultList();
	}
	
	@Override
	public Order checkOut(Order order, Cart cart) {
		
		Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
		List<OrderItem> orderItemList = new ArrayList<>();
		
		for(Map.Entry<Integer, CartItem> map: cartItemMap.entrySet()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setPrice(map.getValue().getProduct().getPrice());
			orderItem.setProduct(map.getValue().getProduct());
			orderItem.setQuantity(map.getValue().getQuantity());
			orderItemList.add(orderItem);
		}
		
		em.persist(order);
		
		Order newOrder = em.merge(order);
		
		for(OrderItem orderItem : orderItemList) {
			orderItem.setOrder(newOrder);
			em.persist(orderItem);
			
			InventoryItem inventoryItem = inventoryRepository.findByProductId(orderItem.getProduct().getId());

			if(inventoryItem.getQuantity() < orderItem.getQuantity()) {
				
				return null;
			}
			
			inventoryItem.setQuantity(inventoryItem.getQuantity()-orderItem.getQuantity());
			em.merge(inventoryItem);
		}
		
		return newOrder;
	}

}
