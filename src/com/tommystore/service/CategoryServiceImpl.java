package com.tommystore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tommystore.domain.Category;
import com.tommystore.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public Category find(Integer id) {
		
		return categoryRepository.find(id);
	}

	@Override
	@Transactional
	public Category save(Category category) {
		
    	String uuid = UUID.randomUUID().toString().replace("-", "");
        category.setCategoryId("CAT-"+uuid);
        
		return categoryRepository.save(category);
	}

	@Override
	@Transactional
	public List<Category> findCategories() {
		
		return categoryRepository.findCategories();
	}

	@Override
	@Transactional
	public Map<Integer, String> getCategoryMap() {
		
		Map<Integer, String> categoryMap = new HashMap<>();
		List<Category> categoryList = categoryRepository.getCategoryList();
		
		for(Category category : categoryList) {
			categoryMap.put(category.getId(), category.getName());
		}
		
		return categoryMap;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		categoryRepository.delete(id);
	}

	@Override
	@Transactional
	public Boolean isCategoryExistByName(String name) {
		
		return categoryRepository.isCategoryExistByName(name);
	}

	@Override
	public Boolean isValidToEditByIdAndName(Integer id, String name) {
		
		return categoryRepository.isValidCategoryName(id, name);
	}

}
