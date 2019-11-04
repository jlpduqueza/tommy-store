package com.tommystore.repository;

import java.util.List;
import com.tommystore.domain.Category;

public interface CategoryRepository {

	public Category find(Integer id);
	public Category save(Category category);
	
	public List<Category> findCategories();
	public List<Category> getCategoryList();
	
	public Boolean isCategoryExistByName(String name);
	public Boolean isValidCategoryName(Integer id, String name);
	
	public void delete(Integer id) ;
	
}
