package com.ilkerbas.spring.inventory.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.inventory.business.dto.CategoryDto;
import com.ilkerbas.spring.inventory.business.service.CategoryService;

/*
 * Rest Service/Resource for Category
 * Communicates with MVC Client
 * Takes Dto's from MVC Client Controller
 * Sends DTO to Service
 */

@RestController
@RequestMapping("/inventory")
public class CategoryResource {

	// CategoryService interface, Constructor injection
	private CategoryService categoryService;
	
	public CategoryResource(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	// get all categories
	@GetMapping("/categories")
	public List<CategoryDto> getAllCategories() {
		
		List<CategoryDto> listCategoryDtos = categoryService.findAll();
		
		return listCategoryDtos;
	}
	
}
