package com.tommystore.repository;

import java.util.List;

import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.StockHistory;
import com.tommystore.domain.User;

public interface InventoryRepository {

	public InventoryItem find(Integer id);
	public InventoryItem findByProductId(Integer id);
	public InventoryItem save(InventoryItem inventoryItem, User user);
	
	public List<InventoryItem> findInventoryItems();
	public List<StockHistory> findStockHistories(Integer id);
	public List<InventoryItem> findByStock(int stock);
	
}
