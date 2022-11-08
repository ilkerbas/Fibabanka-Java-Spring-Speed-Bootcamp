package com.ilkerbas.spring.shopping.business.dto;

import java.util.List;


public class CartDto {

	// fields
	private long cartId;
	
	private String customerName;
	
	private long totalAmount;
	
	private boolean cartStatus;
	
	private List<CartProductDto> cartProductDtos;
	
	// NoArgs Constructor
	public CartDto() {
		
	}

	// AllArgs Constructor
	public CartDto(long cartId, String customerName, long totalAmount, boolean cartStatus,
			List<CartProductDto> cartProductDtos) {
		this.cartId = cartId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
		this.cartProductDtos = cartProductDtos;
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

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

	public List<CartProductDto> getCartProductDtos() {
		return cartProductDtos;
	}

	public void setCartProductDtos(List<CartProductDto> cartProductDtos) {
		this.cartProductDtos = cartProductDtos;
	}
	
}
