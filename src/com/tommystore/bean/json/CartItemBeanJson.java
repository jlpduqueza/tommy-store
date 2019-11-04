package com.tommystore.bean.json;

import java.math.BigDecimal;

import com.tommystore.domain.CartItem;

public class CartItemBeanJson {

	private int id;
	
	private String name;

	private String price;

	private String stockStatus;

	private int quantity;

	private String picturePath;

	private BigDecimal subTotalPrice;

	private BigDecimal totalPrice;
	
	private String category;

	public CartItemBeanJson() {
		
	}
	
	public CartItemBeanJson(CartItem cartItem, String stockStatus) {
		
		this.id = cartItem.getProduct().getId();
		this.name = cartItem.getProduct().getName();
		this.price = cartItem.getProduct().getPrice().toString();
		this.category = cartItem.getProduct().getName();
		this.picturePath = cartItem.getProduct().getPicturePath();
		this.quantity = cartItem.getQuantity();
		this.subTotalPrice = cartItem.getProduct().getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
		this.stockStatus = stockStatus;
	}
	
	public CartItemBeanJson(CartItem cartItem) {
		
		this.id = cartItem.getProduct().getId();
		this.name = cartItem.getProduct().getName();
		this.price = cartItem.getProduct().getPrice().toString();
		this.category = cartItem.getProduct().getName();
		this.picturePath = cartItem.getProduct().getPicturePath();
		this.quantity = cartItem.getQuantity();
		this.subTotalPrice = cartItem.getProduct().getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getPrice() {
		return price;
	}

	
	public void setPrice(String price) {
		this.price = price;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public String getPicturePath() {
		return picturePath;
	}

	
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	
	public String getCategory() {
		return category;
	}

	
	public void setCategory(String category) {
		this.category = category;
	}

	
	public String getStockStatus() {
		return stockStatus;
	}

	
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	
	public BigDecimal getSubTotalPrice() {
		return subTotalPrice;
	}

	
	public void setSubTotalPrice(BigDecimal subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	
}
