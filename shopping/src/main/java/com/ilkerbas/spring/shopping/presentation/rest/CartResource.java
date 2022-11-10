package com.ilkerbas.spring.shopping.presentation.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.shopping.business.dto.CartDto;
import com.ilkerbas.spring.shopping.business.dto.CartProductDto;
import com.ilkerbas.spring.shopping.business.service.CartService;

@RestController
public class CartResource {

	private CartService cartService;
	
	@Autowired
	public CartResource(CartService cartService) {
		this.cartService = cartService;
	}
	
	@PostMapping("/shopping/cart/create")
	public long create(@RequestBody CartDto cartDto) {
		
		long cartId = cartService.create(cartDto);
		
		System.out.println("Cart id: " + cartId + 
				"Customer name: " + cartDto.getCustomerName());
		return cartId;
	}
	
	@PostMapping("/shopping/cart/add")
	public CartProductDto add(@RequestBody CartProductDto cartProductDto) {
		
		
		CartProductDto productDto = cartService.addProduct(cartProductDto);
		
		System.out.println(productDto.getCartProductId() + " + cartId: " + productDto.getCartId());
		return productDto;
	}
	
	@GetMapping("/shopping/cart/find/{cartId}")
	public CartDto find(@PathVariable("cartId") long cartId) {
		
		CartDto cartDto = cartService.find(cartId);
		
		
		return cartDto;
	}
	
	@GetMapping("/shopping/checkout/{cartId}")
	public Boolean checkout(@PathVariable("cartId") long cartId) {
		
		boolean result = cartService.checkout(cartId);
		
		return result;
	}
}
