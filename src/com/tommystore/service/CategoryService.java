package com.tommystore.service;

import java.util.List;
import java.util.Map;

import com.tommystore.domain.Category;

public interface CategoryService {
	
	public Category find(Integer id);
	public Category save(Category category);
	
	public List<Category> findCategories();
	
	public Map<Integer, String> getCategoryMap();
	
	public Boolean isCategoryExistByName(String name);
	public Boolean isValidToEditByIdAndName(Integer id, String name);
	
	public void delete(Integer id);
	
}
