package com.tommystore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_history")
public class StockHistory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional=false) 
	private InventoryItem inventoryItem;
	
	@ManyToOne(optional=false) 
	private User user;
	
	private int updatedQuantity;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	public int getUpdatedQuantity() {
		return updatedQuantity;
	}

	public void setUpdatedQuantity(int updatedQuantity) {
		this.updatedQuantity = updatedQuantity;
	}

}
