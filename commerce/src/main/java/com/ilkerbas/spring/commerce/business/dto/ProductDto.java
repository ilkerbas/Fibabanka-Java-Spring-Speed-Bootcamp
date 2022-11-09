package com.ilkerbas.spring.commerce.business.dto;

//Product data transfer object
public class ProductDto {

	// fields
	private long productId;

	private String productName;

	private double salesPrice;

	private long categoryId;

	// NoArgsConstructor
	public ProductDto() {
	}

	// AllArgsConstructor
	public ProductDto(long productId, String productName, double salesPrice, long categoryId) {
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
