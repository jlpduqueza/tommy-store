package com.tommystore.bean.json;

import java.math.BigDecimal;

import com.tommystore.domain.Product;

public class ProductBeanJson {

	private Integer id;
	
	private String name;
	
	private BigDecimal price;
	
	private int categoryId;
	
	private String category;
	
	private String quantity;

	private String picturePath;
	
	public ProductBeanJson() {
		
	}
	
	public ProductBeanJson(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.categoryId = product.getCategory().getId();
		this.category = product.getCategory().getName();
		this.picturePath = product.getPicturePath();		
		
		int quantity = product.getInventoryItem().getQuantity();
		
		if(quantity >= 50) {
			this.quantity = "In Stock";
		}
		
		else if(quantity < 50 && quantity > 0) {
			this.quantity = "Only "+quantity+" left in stock";
		}
		
		else if(quantity < 1 ) {
			this.quantity = "No Stock";
		}
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
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public String getPicture() {
		return picturePath;
	}

	public void setPicture(String picture) {
		this.picturePath = picture;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	
}
