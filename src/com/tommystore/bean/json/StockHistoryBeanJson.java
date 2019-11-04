package com.tommystore.bean.json;

import java.util.Date;

import com.tommystore.domain.StockHistory;

public class StockHistoryBeanJson {

	private Integer id;
	
	private String productName;
	
	private String modifiedBy;
	
	private int updatedQuantity;
	
	private Date dateUpdated;

	public StockHistoryBeanJson() {
		
	}
	
	public StockHistoryBeanJson(StockHistory stockHistory) {
		this.id = stockHistory.getId();
		this.productName = stockHistory.getInventoryItem().getProduct().getName();
		this.modifiedBy = stockHistory.getUser().getFirstName();
		this.updatedQuantity = stockHistory.getUpdatedQuantity();
		this.dateUpdated = stockHistory.getInventoryItem().getUpdateDateTime();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getUpdatedQuantity() {
		return updatedQuantity;
	}

	public void setUpdatedQuantity(int updatedQuantity) {
		this.updatedQuantity = updatedQuantity;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	
}
