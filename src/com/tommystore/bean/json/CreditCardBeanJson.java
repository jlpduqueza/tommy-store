package com.tommystore.bean.json;

import com.tommystore.domain.CreditCard;

public class CreditCardBeanJson {

	private String cardNumber;
	
	private String securityCode;
	
	private Integer id;

	public CreditCardBeanJson() {
		
	}

	public CreditCardBeanJson(CreditCard creditCard) {
		this.id = creditCard.getId();
		this.cardNumber = creditCard.getCardNumber();
		this.securityCode = creditCard.getSecurityCode();
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public String getSecurityCode() {
		return securityCode;
	}

	
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
