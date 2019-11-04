package com.tommystore.domain;

import java.util.Map;

public class Cart {

	private Map<Integer, CartItem> cartItemMap;

	public Map<Integer, CartItem> getCartItemMap() {
		return cartItemMap;
	}

	public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
		this.cartItemMap = cartItemMap;
	}

}
