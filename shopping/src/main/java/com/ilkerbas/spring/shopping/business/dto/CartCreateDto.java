package com.ilkerbas.spring.shopping.business.dto;

// Cart Create Data Transfer Object
public class CartCreateDto {

	// fields
	private long cartId;
	
	private String customerName;
	
	// NoArgs constructor
	public CartCreateDto() {
		
	}

	// AllArg Constructor
	public CartCreateDto(long cartId, String customerName) {
		this.cartId = cartId;
		this.customerName = customerName;
	}

	// getters & setters
	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
