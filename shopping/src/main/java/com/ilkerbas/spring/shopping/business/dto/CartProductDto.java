package com.ilkerbas.spring.shopping.business.dto;


// Cart Product Data Transfer Object
public class CartProductDto {

	// fields 
	private long cartProductId;
	
	private long productId;
	
	private int salesQuantity;
	
	private long salesPrice;
	
	private int lineAmount;
	
	private CartDto cartDto;
	
	// NoArgs Constructor
	public CartProductDto() {
	}

	// FullArgs Constructor
	public CartProductDto(long cartProductId, long productId, int salesQuantity, long salesPrice, int lineAmount,
			CartDto cartDto) {
		this.cartProductId = cartProductId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = lineAmount;
		this.cartDto = cartDto;
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

	public CartDto getCartDto() {
		return cartDto;
	}

	public void setCartDto(CartDto cartDto) {
		this.cartDto = cartDto;
	}
	
	
}
