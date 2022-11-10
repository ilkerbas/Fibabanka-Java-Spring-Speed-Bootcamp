package com.ilkerbas.spring.commerce.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilkerbas.spring.commerce.business.dto.CartDto;
import com.ilkerbas.spring.commerce.business.dto.CartProductDto;
import com.ilkerbas.spring.commerce.business.dto.CategoryDto;
import com.ilkerbas.spring.commerce.business.dto.ProductDto;
import com.ilkerbas.spring.commerce.presentation.client.InventoryClient;
import com.ilkerbas.spring.commerce.presentation.client.ShoppingClient;

// Commerce Service implementation
// Communicates with inventory and shopping client
@Service
public class CommerceServiceImpl implements CommerceService {

	@Autowired
	private InventoryClient inventoryClient;
	
	@Autowired
	private ShoppingClient shoppingClient;
	
	
	// get all categories
	@Override
	public List<CategoryDto> findAllCategories() {
		
		List<CategoryDto> categoryDtos = inventoryClient.findAllCategories();
		
		return categoryDtos;
	}

	// read product by id
	@Override
	public ProductDto findProduct(long productId) {

		ProductDto productDto = inventoryClient.findProduct(productId);
		
		return productDto;
	}

	// read products by categoryId
	@Override
	public List<ProductDto> findAllByCategoryId(long categoryId) {

		List<ProductDto> productDtos = inventoryClient.findAllByCategoryId(categoryId);
		
		return productDtos;
	}

	// delete cart product
	@Override
	public void deleteCartProduct(long cartId, long productId) {
		
		shoppingClient.deleteCartProduct(cartId, productId);
		
	}

	// create with given cart create DTO
	// return cartId
	@Override
	public long create(CartDto cartDto) {
		
		long cartId = shoppingClient.create(cartDto);
		
		return cartId;
	}

	// add cartProduct to cart
	@Override
	public CartProductDto addProduct(CartProductDto cartProductDto) {
		
		CartProductDto productDto = shoppingClient.addProduct(cartProductDto);
		
		productDto.setProductName(getProductName(productDto.getProductId()));
		
		return productDto;
	}

	// find cart by given id
	@Override
	public CartDto find(long cartId) {

		CartDto cartDto = shoppingClient.find(cartId);
		
		return cartDto;
	}

	// checkout
	@Override
	public boolean checkout(long cartId) {
		
		return shoppingClient.checkout(cartId);
	}

	@Override
	public String getProductName(long productId) {

		String productName = inventoryClient.findProduct(productId).getProductName();
		return productName;
	}

}
