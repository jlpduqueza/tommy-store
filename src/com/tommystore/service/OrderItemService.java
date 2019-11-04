package com.tommystore.service;

import java.util.List;

import com.tommystore.domain.Cart;
import com.tommystore.domain.Order;
import com.tommystore.domain.OrderItem;
import com.tommystore.domain.Product;

public interface OrderItemService {
	
	public List<OrderItem> generateOrderItem(Cart cart);
	public List<OrderItem> findOrderItemsByProductId(Integer id);
	
	public List<Product> findPopularProducts();

	public 	void checkOut(Order order, Cart cart);
	
}
