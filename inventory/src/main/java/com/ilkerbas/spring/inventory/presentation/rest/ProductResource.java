package com.ilkerbas.spring.inventory.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.inventory.business.dto.ListProductDto;
import com.ilkerbas.spring.inventory.business.service.IProductService;

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
	private IProductService productService;
	
	public ProductResource(IProductService productService) {
		this.productService = productService;
	}
	
	// get products by given category id
	@GetMapping("/products/{categoryId}")
	public List<ListProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId){
		
		List<ListProductDto> listProductDtos = productService.findAllByCategoryId(categoryId);
		
		return listProductDtos;
	}
	
	// get product by given id
	@GetMapping("/product/{id}")
	public ListProductDto getProductById(@PathVariable("id") long productId) {
		
		ListProductDto listProductDto = productService.find(productId);
		
		return listProductDto;
	}
}
