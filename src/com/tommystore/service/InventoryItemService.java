package com.tommystore.service;

import java.util.List;

import com.tommystore.domain.CartItem;
import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.Product;
import com.tommystore.domain.StockHistory;
import com.tommystore.domain.User;

public interface InventoryItemService {
	
	public InventoryItem find(Integer id);
	public InventoryItem save(InventoryItem inventoryItem, User user);
	public InventoryItem replenishStock(InventoryItem inventoryItem, User user);
	
	public boolean isValidQuantity(String quantity);
	public boolean isQuantitySufficient(CartItem cartItem, Product product);
	
	public List<InventoryItem> findInventoryItems();
	public List<InventoryItem> findInventoryItemListByStock();
	
	public List<StockHistory> findStockHistories(Integer id);
}

