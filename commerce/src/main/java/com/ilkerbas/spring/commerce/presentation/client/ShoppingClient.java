package com.ilkerbas.spring.commerce.presentation.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ilkerbas.spring.commerce.business.dto.CartDto;
import com.ilkerbas.spring.commerce.business.dto.CartProductDto;


//Client for shopping MicroService
//Communicates with RestTemplate
@Component
public class ShoppingClient {

	// delete cart product by given cartId and productId
	public void deleteCartProduct(long cartId, long productId) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8082/shopping/cart/"
				+ cartId + "/remove/" + productId;
		
		restTemplate.delete(url);
		
	}

	// create a cart
	public long create(CartDto cartDto) {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8082/shopping/cart/create";
		
		Long cartId = restTemplate.postForObject(url, cartDto, Long.class);
		
		return cartId;
	}

	// add product to cart
	public CartProductDto addProduct(CartProductDto cartProductDto) {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8082/shopping/cart/add";
		
		CartProductDto cartProduct =  restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
		
		return cartProduct;
	}

	// find cart by id
	public CartDto find(long cartId) {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8082/shopping/cart/find/" + cartId;
		
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);
		
		return cartDto;
	}

	// checkout
	public boolean checkout(long cartId) {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8082/shopping/checkout/" + cartId;
		
		boolean result = restTemplate.getForObject(url, Boolean.class);
		
		return result;
	}
}
