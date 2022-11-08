package com.ilkerbas.spring.inventory.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.inventory.business.dto.ListProductDto;
import com.ilkerbas.spring.inventory.data.entity.Product;
import com.ilkerbas.spring.inventory.data.repository.ProductRepository;

// Product Service implementation 
@Service
public class ProductService implements IProductService {

	// ProductRepository interface - Constructor injection
	ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// get product by productId
	@Override
	public ListProductDto find(long productId) {

		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			
			Product product = optional.get();
			ListProductDto listProductDto = new ListProductDto(
					product.getProductId(), product.getProductName(), 
					product.getSalesPrice(), product.getCategory().getCategoryId());
			
			return listProductDto;
			
		}
		return null;
	}

	// get all products by given categoryId
	@Override
	public List<ListProductDto> findAllByCategoryId(long categoryId) {

		Iterable<Product> products = 
				productRepository.findAllByCategoryId(categoryId);
		
		List<ListProductDto> productDtos = new ArrayList<>();
		
		for(Product product : products) {
			productDtos.add(
					new ListProductDto(product.getProductId(), product.getProductName(),
							product.getSalesPrice(), product.getCategory().getCategoryId())
					);
		}
		return productDtos;
	}

}
