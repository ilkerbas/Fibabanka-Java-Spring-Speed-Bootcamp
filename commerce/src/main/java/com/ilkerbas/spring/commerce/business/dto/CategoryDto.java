package com.ilkerbas.spring.commerce.business.dto;

// Category Data Transfer Object
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

	// getters & setters
	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
