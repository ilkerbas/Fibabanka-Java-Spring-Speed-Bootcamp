package com.ilkerbas.spring.inventory.business.service;

import java.util.List;

import com.ilkerbas.spring.inventory.business.dto.CategoryDto;

/* 
 * Category Service interface
 * Applies IoC
 * Classes that implements
 * have to follow this interface
*/

public interface CategoryService {

	// get all categories
	List<CategoryDto> findAll();
}
