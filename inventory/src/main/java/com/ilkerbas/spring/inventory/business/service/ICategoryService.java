package com.ilkerbas.spring.inventory.business.service;

import java.util.List;

import com.ilkerbas.spring.inventory.business.dto.ListCategoryDto;

/* 
 * Category Service interface
 * Applies IoC
 * Classes that implements
 * have to follow this interface
*/

public interface ICategoryService {

	// get all categories
	List<ListCategoryDto> findAll();
}
