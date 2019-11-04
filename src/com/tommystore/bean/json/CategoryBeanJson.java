package com.tommystore.bean.json;

import com.tommystore.domain.Category;

public class CategoryBeanJson {

	private Integer id;

	private String categoryId;
	
	private String name;

	public CategoryBeanJson() {
		
	}
	
	public CategoryBeanJson(Category category) {
		this.id = category.getId();
		this.categoryId = category.getCategoryId();
		this.name = category.getName();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
