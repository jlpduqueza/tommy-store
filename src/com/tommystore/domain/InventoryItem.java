package com.tommystore.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "inventory_item")
public class InventoryItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(optional=false)
	private Product product;

	@Min(0)
	private int quantity;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDateTime;
	
	@OneToMany(mappedBy="inventoryItem", orphanRemoval=true)
	private List<StockHistory> stockHistoryList;

	public Integer getId() {
		return id;
	}
	
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
	public int getQuantity() {
		return quantity;
	}

	public List<StockHistory> getStockHistoryList() {
		return stockHistoryList;
	}
	
	public void setStockHistoryList(List<StockHistory> stockHistoryList) {
		this.stockHistoryList = stockHistoryList;
	}
}
