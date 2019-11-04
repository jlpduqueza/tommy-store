package com.tommystore.repository;

import java.util.Date;
import java.util.List;

import com.tommystore.domain.Cart;
import com.tommystore.domain.Order;
import com.tommystore.domain.OrderItem;
import com.tommystore.domain.Product;

public interface OrderItemRepository {

	public List<Product> findPopularProducts(Date range);
	public List<OrderItem> findOrderItemsProductId(Integer id);
	
	public Order checkOut(Order order, Cart cart);
	
}
