package com.ilkerbas.spring.shopping.business.service;

import com.ilkerbas.spring.shopping.business.dto.CartDto;
import com.ilkerbas.spring.shopping.business.dto.CartProductDto;

// Cart Service interface
public interface CartService {

	// create with given cart create DTO
	// return cartId
	long create(CartDto cartDto);
	
	// add cartProduct to cart
	CartProductDto addProduct(CartProductDto cartProductDto);
	
	// find cart by given id
	CartDto find(long cartId);
	
	// checkout
	boolean checkout(long cartId);
}
