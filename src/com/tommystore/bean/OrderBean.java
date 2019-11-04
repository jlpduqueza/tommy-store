package com.tommystore.bean;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.tommystore.constant.PaymentType;
import com.tommystore.domain.CreditCard;
import com.tommystore.domain.ShippingAddress;

public class OrderBean {
	
	@NotNull
	private ShippingAddress shippingAddress;
	
	@NotNull
	private CreditCard creditCard;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	public PaymentType getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
