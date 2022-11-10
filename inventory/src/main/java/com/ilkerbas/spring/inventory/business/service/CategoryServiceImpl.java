package com.ilkerbas.spring.inventory.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.inventory.business.dto.CategoryDto;
import com.ilkerbas.spring.inventory.data.entity.Category;
import com.ilkerbas.spring.inventory.data.repository.CategoryRepository;

// Category Service implementation
@Service
public class CategoryServiceImpl implements CategoryService {

	// CategoryRepository interface - Constructor injection
	CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	// get all categories
	@Override
	public List<CategoryDto> findAll() {
		
		Iterable<Category> categories = categoryRepository.findAll();
		
		List<CategoryDto> categoryDtos = new ArrayList<>();
		
		for(Category category : categories) {
			categoryDtos.add(
					new CategoryDto(category.getCategoryId(), category.getCategoryName())
					);
		}
		return categoryDtos;
	}

}
