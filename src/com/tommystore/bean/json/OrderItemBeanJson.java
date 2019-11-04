package com.tommystore.bean.json;

import java.util.Date;

import com.tommystore.domain.OrderItem;

public class OrderItemBeanJson {
	
	private Integer orderNumber;
	
	private Date dateOrdered;
	
	private int quantityOrdered;

	public OrderItemBeanJson() {
		
	}
	
	public OrderItemBeanJson(OrderItem orderItem) {
		this.orderNumber = orderItem.getId();
		this.dateOrdered = orderItem.getOrder().getPurchaseDate();
		this.quantityOrdered = orderItem.getQuantity();
	}
	
	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}
	
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	
}
