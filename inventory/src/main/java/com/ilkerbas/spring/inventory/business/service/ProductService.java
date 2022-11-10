package com.ilkerbas.spring.inventory.business.service;

import java.util.List;

import com.ilkerbas.spring.inventory.business.dto.ProductDto;

/* 
 * Product Service interface
 * Applies IoC
 * Classes that implements
 * have to follow this interface
*/

public interface ProductService {

	// read product by id
	ProductDto find(long productId);
	
	// read products by categoryId
	List<ProductDto> findAllByCategoryId(long categoryId);
}
