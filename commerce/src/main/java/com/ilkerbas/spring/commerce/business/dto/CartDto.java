package com.ilkerbas.spring.commerce.business.dto;

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


		public CartDto(long cartId) {
			this.cartId = cartId;
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
