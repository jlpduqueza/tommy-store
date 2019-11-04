package com.tommystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommystore.domain.CartItem;
import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.Product;
import com.tommystore.domain.StockHistory;
import com.tommystore.domain.User;
import com.tommystore.repository.InventoryRepository;

@Service
@PropertySource("/WEB-INF/properties")
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Value("${inventory.nstock}")
	private int nStock;
	
	@Override
	@Transactional
	public InventoryItem find(Integer id) {
		
		return inventoryRepository.find(id);
	}

	@Override
	@Transactional
	public InventoryItem save(InventoryItem inventoryItem, User user) {
		
		return inventoryRepository.save(inventoryItem, user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<InventoryItem> findInventoryItems() {
		
		return inventoryRepository.findInventoryItems();
	}

	@Override
	@Transactional(readOnly = true)
	public List<InventoryItem> findInventoryItemListByStock() {
		
		return inventoryRepository.findByStock(nStock);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StockHistory> findStockHistories(Integer id) {
		
		return inventoryRepository.findStockHistories(id);
	}

	@Override
	public boolean isValidQuantity(String quantity) {
		
		try {
			Integer.parseInt(quantity);
			
			return true;
		} catch (NumberFormatException e) {
			
			return false;
		}
	}

	@Override
	@Transactional
	public InventoryItem replenishStock(InventoryItem inventoryItem, User user) {
		
        InventoryItem inventoryItemToMerge = find(inventoryItem.getId());
        inventoryItemToMerge.setQuantity(inventoryItemToMerge.getQuantity()+inventoryItem.getQuantity());
        
		return save(inventoryItemToMerge, user);
	}


	@Override
	@Transactional(readOnly = true)
	public boolean isQuantitySufficient(CartItem cartItem, Product product) {
		
		return inventoryRepository.find(product.getId()).getQuantity() >= cartItem.getQuantity();
	}

}
