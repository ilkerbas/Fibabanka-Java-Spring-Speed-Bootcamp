package com.ilkerbas.spring.shopping.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//CartProduct Entity

@Entity
public class CartProduct {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartProductId;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	private long productId;
	
	private int salesQuantity;
	
	private long salesPrice;
	
	private int lineAmount;

	// AllArgs constructor
	public CartProduct(long cartProductId, long productId, int salesQuantity, long salesPrice,
			int lineAmount) {
		this.cartProductId = cartProductId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = lineAmount;
	}

	// NoArgs constructor
	public CartProduct() {
	}

	// getters & setters
	public long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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
	
}
