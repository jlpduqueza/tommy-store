package com.tommystore.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "product" ,uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "category_id"}) })
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(nullable=false)
	private String productId;

	@NotNull
	@Column(nullable=false)
	private String name;
	
	@NotNull
	@Column(nullable=false, precision=9, scale=2)
	@Digits(fraction = 2, integer = 7)
	private BigDecimal price;

	@NotNull
	@ManyToOne(optional=false) 
	private Category category;
	
	@OneToOne(mappedBy="product", optional=false, orphanRemoval=true, cascade=CascadeType.ALL)  
	private InventoryItem inventoryItem;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDateTime;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;
	
	private String picturePath;

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}
	
	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}
	
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String id) {
		this.productId = id;
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

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}
