package com.tommystore.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@ManyToOne(optional=false)
	private Product product;

	@NotNull
	@ManyToOne(optional=false)
	private Order order;

	@Column(nullable=false)
	private int quantity;
	
	@NotNull
	@Column(nullable=false, precision=9, scale=2)
	@Digits(fraction = 2, integer = 7)
	private BigDecimal price;
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
