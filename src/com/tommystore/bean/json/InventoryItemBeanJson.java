package com.tommystore.bean.json;

import java.math.BigDecimal;
import java.util.Date;

import com.tommystore.domain.InventoryItem;

public class InventoryItemBeanJson {

	private Integer id;

	private String productName;

	private String productId;

	private int quantity;

	private BigDecimal price;
	
	private Date dateUpdated;

	private String picturePath;
	

	public InventoryItemBeanJson() {
		
	}
	
	public InventoryItemBeanJson(InventoryItem inventoryItem) {
		this.id = inventoryItem.getId();
		this.productId = inventoryItem.getProduct().getProductId();
		this.productName = inventoryItem.getProduct().getName();
		this.quantity = inventoryItem.getQuantity();
		this.dateUpdated = inventoryItem.getUpdateDateTime();
		this.picturePath = inventoryItem.getProduct().getPicturePath();
		this.price = inventoryItem.getProduct().getPrice();
	}

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getProductName() {
		return productName;
	}

	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public Date getDateUpdated() {
		return dateUpdated;
	}

	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	
	public String getPicturePath() {
		return picturePath;
	}

	
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	
	public String getProductId() {
		return productId;
	}

	
	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	public BigDecimal getPrice() {
		return price;
	}

	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
