package com.ilkerbas.spring.inventory.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.inventory.business.dto.ListCategoryDto;
import com.ilkerbas.spring.inventory.data.entity.Category;
import com.ilkerbas.spring.inventory.data.repository.CategoryRepository;

// Category Service implementation
@Service
public class CategoryService implements ICategoryService {

	// CategoryRepository interface - Constructor injection
	CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	// get all categories
	@Override
	public List<ListCategoryDto> findAll() {
		
		Iterable<Category> categories = categoryRepository.findAll();
		
		List<ListCategoryDto> categoryDtos = new ArrayList<>();
		
		for(Category category : categories) {
			categoryDtos.add(
					new ListCategoryDto(category.getCategoryId(), category.getCategoryName())
					);
		}
		return categoryDtos;
	}

}
