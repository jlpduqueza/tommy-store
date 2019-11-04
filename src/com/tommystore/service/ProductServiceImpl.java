package com.tommystore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.Product;
import com.tommystore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public Product find(Integer id) {
		
		return productRepository.find(id);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		
		if(product.getId() == null) {
	    	String uuid = UUID.randomUUID().toString().replace("-", "");
	        product.setProductId("PROD-"+uuid);
	        
	    	InventoryItem inventoryItem = new InventoryItem();
	    	inventoryItem.setQuantity(0);
	    	inventoryItem.setProduct(product);
	    	product.setInventoryItem(inventoryItem);
		}
		
		return productRepository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProducts() {
		
		return productRepository.findProducts();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		productRepository.delete(id);
	}

	@Override
	@Transactional
	public Boolean isExistByNameAndCategoryId(String name, Integer id) {
		
		return productRepository.isExistByNameAndCategoryId(name, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProductByCategoryId(Integer id) {
		
		return productRepository.findProductByCategoryId(id);
	}

	@Override
	@Transactional
	public Boolean isPriceValid(String price) {
		
		try {
			new BigDecimal(price);
			
			return true;
		} catch (NumberFormatException e) {
			
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean isNameValid(String name, Integer id) {
		
		return productRepository.isNameValid(name, id);
	}

	@Override
	@Transactional
	public List<Product> searchProduct(String keyword) {
		
		return productRepository.searchProduct(keyword);
	}

	@Override
	@Transactional
	public List<String> findSearchCriterias() {
		
		List<String> criteriaList = new ArrayList<>();
		criteriaList.add("Category");
		criteriaList.add("All");
		criteriaList.add("Name");
		
		return criteriaList;
	}

	@Override
	@Transactional
	public Boolean isExistByPicture(MultipartFile file) {
		
		return productRepository.isExistByPicture(file);
	}

	@Override
	public List<Product> searchProductByCategory(String keyword) {
		
		return productRepository.searchProductByCategory(keyword);
	}

	@Override
	public List<Product> searchProductByName(String keyword) {
		
		return productRepository.searchProductByName(keyword);
	}

}
