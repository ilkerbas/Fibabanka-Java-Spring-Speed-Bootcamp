package com.ilkerbas.spring.inventory.business.dto;


// Product data transfer object

public class ListProductDto {

	// fields
	private long productId;
	
	private String productName;
	
	private double salesPrice;
	
	private long categoryId;

	// NoArgsConstructor
	public ListProductDto() {
	}

	// AllArgsConstructor
	public ListProductDto(long productId, String productName, double salesPrice, long categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.categoryId = categoryId;
	}

	// getters
	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public long getCategoryId() {
		return categoryId;
	}
	
}
