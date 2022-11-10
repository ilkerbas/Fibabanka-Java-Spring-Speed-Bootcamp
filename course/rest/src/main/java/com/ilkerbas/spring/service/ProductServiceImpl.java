package com.ilkerbas.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product find(long productId) {
		
		Product product = new Product(productId, "Cep Telefonu", 1450);
		System.out.println("İşgörü çalıştı.");
		return product;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(301, "Cep Telefonu", 1450));
		productList.add(new Product(302, "Dizüstü Bilgisayar", 6575));
		productList.add(new Product(303, "Masaüstü Bilgisayar", 3490));
		
		return productList;
	}

	@Override
	public void createProduct(Product product) {
		
		product.setProductId(301);
		System.out.println("Ürün eklendi " + product.getProductId() + " "
				+ product.getProductName() + " " + product.getSalesPrice());
	}

	@Override
	public void updateProduct(Product product) {
		System.out.println("Ürün güncellendi " + product.getProductId() + " "
				+ product.getProductName() + " " + product.getSalesPrice());
	}

	@Override
	public void deleteProduct(long productId) {
		System.out.println("Ürün silindi " + productId);
	}

}
