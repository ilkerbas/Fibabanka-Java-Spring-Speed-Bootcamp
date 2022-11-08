package com.ilkerbas.spring.inventory.business.dto;


// Category data transfer object
// List categories

public class ListCategoryDto {
	
	// fields
	private long categoryId;
	
	private String categoryName;
	
	// no-argument constructor
	public ListCategoryDto() {
		
	}

	// AllArgsConstructor
	public ListCategoryDto(long categoryId, String categoryName) {
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
