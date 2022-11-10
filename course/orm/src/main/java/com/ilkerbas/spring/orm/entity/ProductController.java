package com.ilkerbas.spring.orm.entity;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ilkerbas.spring.orm.data.entity.Product;

@Controller
@RequestMapping("/inventory")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		Product product = new Product(0, "Cep Telefonu", 1430);
		productRepository.save(product);
		return "Ekleme tamamlandı!: " + product.getProductId();
	}
	
	@GetMapping("/product/find")
	@ResponseBody
	public String findProduct() {
		long productId=1;
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			Product product = optional.get();
			System.out.println(product.getProductId() + " "
					+ product.getProductName() + " "
					+ product.getSalesPrice());
			return "Ürün bulundu: " + product.getProductName();
		}
		return "Ürün bulunamadı";
	}
	
	@GetMapping("/product/list")
	@ResponseBody
	public String listProduct() {

		Iterable<Product> products = productRepository.findAll();
		
		int count = 0;
		for(Product product: products) {
			System.out.println(product.getProductId() + " "
					+ product.getProductName() + " "
					+ product.getSalesPrice());
			count++;
		}
		
		return "Ürün sayısı " + count;
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId = 1;
		if(!productRepository.existsById(productId)) {
			return "Ürün bulunamadı " + productId;
		}
		productRepository.deleteById(productId);
		return "Silindi. ";
	}
	
	@GetMapping("/product/expensive")
	@ResponseBody
	public String listExpensiveProducts() {

		double minPrice= 1200;
		Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
		
		int count = 0;
		for(Product product: products) {
			System.out.println(product.getProductId() + " "
					+ product.getProductName() + " "
					+ product.getSalesPrice());
			count++;
		}
		
		return "Ürün sayısı " + count;
	}
	
}
