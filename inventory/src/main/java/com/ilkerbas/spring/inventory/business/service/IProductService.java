package com.ilkerbas.spring.inventory.business.service;

import java.util.List;

import com.ilkerbas.spring.inventory.business.dto.ListProductDto;

/* 
 * Product Service interface
 * Applies IoC
 * Classes that implements
 * have to follow this interface
*/

public interface IProductService {

	// read product by id
	ListProductDto find(long productId);
	
	// read products by categoryId
	List<ListProductDto> findAllByCategoryId(long categoryId);
}
