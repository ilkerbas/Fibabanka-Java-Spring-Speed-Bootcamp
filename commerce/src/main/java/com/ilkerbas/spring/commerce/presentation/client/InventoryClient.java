package com.ilkerbas.spring.commerce.presentation.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ilkerbas.spring.commerce.business.dto.CategoryDto;
import com.ilkerbas.spring.commerce.business.dto.ProductDto;

// Client for inventory MicroService
// Communicates with RestTemplate
@Component
public class InventoryClient {

	// find all categories
	public List<CategoryDto> findAllCategories() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/inventory/categories/";
		
		@SuppressWarnings("unchecked")
		ArrayList<CategoryDto> categories = restTemplate.getForObject(url, ArrayList.class);
		
		return categories;
	}

	// find product by given id
	public ProductDto findProduct(long productId) {

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/inventory/product/" + productId;
		
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}

	// find all products by given category id
	public List<ProductDto> findAllByCategoryId(long categoryId) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/inventory/products/" + categoryId;
		
		@SuppressWarnings("unchecked")
		List<ProductDto> productDtos = restTemplate.getForObject(url, ArrayList.class);
		
		return productDtos;
	}
}
