package com.ilkerbas.spring.inventory.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.inventory.business.dto.ListCategoryDto;
import com.ilkerbas.spring.inventory.business.service.ICategoryService;

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
	private ICategoryService categoryService;
	
	public CategoryResource(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	// get all categories
	@GetMapping("/categories")
	public List<ListCategoryDto> getAllCategories() {
		
		List<ListCategoryDto> listCategoryDtos = categoryService.findAll();
		
		return listCategoryDtos;
	}
	
}
