package com.tommystore.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "category_id", unique = true)
	private String categoryId;

	@NotNull
	@NotBlank
	@Column(nullable=false, unique = true)
	private String name;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;
	
	@OneToMany(mappedBy="category", orphanRemoval=true)
	private List<Product> productList;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}
	
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	public String getCode() {
		return categoryId;
	}

	public void setCode(String code) {
		this.categoryId = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
