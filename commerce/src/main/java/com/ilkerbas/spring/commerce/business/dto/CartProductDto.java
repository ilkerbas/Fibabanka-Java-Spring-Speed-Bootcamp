package com.ilkerbas.spring.commerce.business.dto;

public class CartProductDto {

	// fields 
		private long cartProductId;
		
		private long productId;
		
		private int salesQuantity;
		
		private long salesPrice;
		
		private int lineAmount;
		
		private long cartId;
		
		private String productName;
		
		// NoArgs Constructor
		public CartProductDto() {
		}

		
		public CartProductDto(long cartProductId) {
			this.cartProductId = cartProductId;
		}

		// getters & setters
		public long getCartProductId() {
			return cartProductId;
		}

		public void setCartProductId(long cartProductId) {
			this.cartProductId = cartProductId;
		}

		public long getProductId() {
			return productId;
		}

		public void setProductId(long productId) {
			this.productId = productId;
		}

		public int getSalesQuantity() {
			return salesQuantity;
		}

		public void setSalesQuantity(int salesQuantity) {
			this.salesQuantity = salesQuantity;
		}

		public long getSalesPrice() {
			return salesPrice;
		}

		public void setSalesPrice(long salesPrice) {
			this.salesPrice = salesPrice;
		}

		public int getLineAmount() {
			return lineAmount;
		}

		public void setLineAmount(int lineAmount) {
			this.lineAmount = lineAmount;
		}

		public long getCartId() {
			return cartId;
		}

		public void setCartId(long cartId) {
			this.cartId = cartId;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}
}
