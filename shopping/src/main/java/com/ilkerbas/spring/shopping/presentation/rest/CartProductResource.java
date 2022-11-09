package com.ilkerbas.spring.shopping.presentation.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.shopping.business.service.CartProductService;

@RestController
public class CartProductResource {

	private CartProductService cartProductService;
	
	public CartProductResource(CartProductService cartProductService) {
		this.cartProductService = cartProductService;
	}
	
	
	@DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
	public String delete(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		cartProductService.deleteCartProduct(cartId, productId);
		
		return "Deleted: " + productId;
	}
	
}
