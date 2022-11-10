package com.ilkerbas.spring.inventory.business.dto;


// Category data transfer object
// List categories

public class CategoryDto {
	
	// fields
	private long categoryId;
	
	private String categoryName;
	
	// no-argument constructor
	public CategoryDto() {
		
	}

	// AllArgsConstructor
	public CategoryDto(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	// getters
	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}
	
}
