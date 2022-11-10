package com.ilkerbas.spring.inventory.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.inventory.business.dto.ProductDto;
import com.ilkerbas.spring.inventory.business.service.ProductService;

/*
 * Rest Service/Resource for Product
 * Communicates with MVC Client
 * Takes Dto's from MVC Client Controller
 * Sends DTO to Service
 */

@RestController
@RequestMapping("/inventory")
public class ProductResource {

	// ProductService interface, Constructor injection
	private ProductService productService;
	
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}
	
	// get products by given category id
	@GetMapping("/products/{categoryId}")
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId){
		
		List<ProductDto> listProductDtos = productService.findAllByCategoryId(categoryId);
		
		return listProductDtos;
	}
	
	// get product by given id
	@GetMapping("/product/{id}")
	public ProductDto getProductById(@PathVariable("id") long productId) {
		
		ProductDto listProductDto = productService.find(productId);
		
		return listProductDto;
	}
}
