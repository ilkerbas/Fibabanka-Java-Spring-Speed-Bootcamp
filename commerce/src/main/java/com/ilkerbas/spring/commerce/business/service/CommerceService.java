package com.ilkerbas.spring.commerce.business.service;

import java.util.List;

import com.ilkerbas.spring.commerce.business.dto.CartDto;
import com.ilkerbas.spring.commerce.business.dto.CartProductDto;
import com.ilkerbas.spring.commerce.business.dto.CategoryDto;
import com.ilkerbas.spring.commerce.business.dto.ProductDto;

public interface CommerceService {

	// get all categories
	List<CategoryDto> findAllCategories();
	
	// read product by id
	ProductDto findProduct(long productId);
	
	// read products by categoryId
	List<ProductDto> findAllByCategoryId(long categoryId);
	
	// delete cart product
	void deleteCartProduct(long cartId, long productId);
	
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
