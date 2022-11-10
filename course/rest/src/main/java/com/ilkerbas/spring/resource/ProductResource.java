package com.ilkerbas.spring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.Product;
import com.ilkerbas.spring.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/api/product/{id}")
	public Product getProduct(@PathVariable("id") long productId) {
		Product product = productService.find(productId);
		return product;
	}
	
	@GetMapping("/api/products")
	public List<Product> getProducts() {
		List<Product> productList = productService.findAll();
		return productList;
	}
	
	@PostMapping("/api/product")
	public Product postProduct(@RequestBody Product product) {
		product.setProductId(301);
		productService.createProduct(product);
		
		return product;
	}
	
	@PutMapping("/api/product")
	public void putProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	
	@DeleteMapping("/api/product/{id}")
	public void deleteProduct(@PathVariable("id") long productId) {
		productService.deleteProduct(productId);
	}
}
