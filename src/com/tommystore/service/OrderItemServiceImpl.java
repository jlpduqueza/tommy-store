package com.tommystore.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommystore.domain.Cart;
import com.tommystore.domain.CartItem;
import com.tommystore.domain.Order;
import com.tommystore.domain.OrderItem;
import com.tommystore.domain.Product;
import com.tommystore.repository.OrderItemRepository;

@Service
@PropertySource("/WEB-INF/properties")
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Value("${popularProducts.nDays}")
	private int nDays;

	@Override
	@Transactional
	public List<OrderItem> generateOrderItem(Cart cart) {
		
		Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
		List<OrderItem> orderItemList = new ArrayList<>();
		
		for(Map.Entry<Integer, CartItem> map: cartItemMap.entrySet()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setPrice(map.getValue().getProduct().getPrice());
			orderItem.setProduct(map.getValue().getProduct());
			orderItem.setQuantity(map.getValue().getQuantity());
			orderItemList.add(orderItem);
		}
		
		return orderItemList;
	}

	@Override
	@Transactional
	public List<OrderItem> findOrderItemsByProductId(Integer id) {
		
		return orderItemRepository.findOrderItemsProductId(id);
	}

	@Override
	@Transactional
	public List<Product> findPopularProducts() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -nDays);
		Date oneMonthRange = cal.getTime();
		
		return orderItemRepository.findPopularProducts(oneMonthRange);
	}

	@Override
	@Transactional
	public void checkOut(Order order, Cart cart) {
		
		orderItemRepository.checkOut(order, cart);
	}

}
