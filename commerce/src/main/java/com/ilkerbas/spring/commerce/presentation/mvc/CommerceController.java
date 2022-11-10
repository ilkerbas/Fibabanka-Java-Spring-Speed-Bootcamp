package com.ilkerbas.spring.commerce.presentation.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ilkerbas.spring.commerce.business.dto.CartDto;
import com.ilkerbas.spring.commerce.business.dto.CartProductDto;
import com.ilkerbas.spring.commerce.business.dto.CategoryDto;
import com.ilkerbas.spring.commerce.business.dto.ProductDto;


// MVC Client for CommerceResource REST Resource
@Controller
@RequestMapping("commerce/mvc")
public class CommerceController {
	
	// find all categories
	@GetMapping("/inventory/categories")
	@ResponseBody
	public List<CategoryDto> getAllCategories() {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/inventory/categories/";

		@SuppressWarnings("unchecked")
		ArrayList<CategoryDto> categories = restTemplate.getForObject(url, ArrayList.class);

		return categories;
	}

	// find product by given id
	@GetMapping("/inventory/product/{productId}")
	@ResponseBody
	public ProductDto getProductById(@PathVariable("productId") long productId) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/inventory/product/" + productId;

		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}

	// find all products by given category id
	@GetMapping("/inventory/products/{categoryId}")
	@ResponseBody
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/inventory/products/" + categoryId;

		@SuppressWarnings("unchecked")
		List<ProductDto> productDtos = restTemplate.getForObject(url, ArrayList.class);

		return productDtos;
	}

	// delete cart product by given cartId and productId
	@DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
	@ResponseBody
	public void deleteCartProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/shopping/cart/" + cartId + "/remove/" + productId;

		restTemplate.delete(url);

	}

	// create a cart
	@GetMapping("/shopping/cart/create")
	@ResponseBody
	public long postCart() {

		/*CartDto postedCartDto = new CartDto(
				0, "IlkerBas",
				3245, false,
				new ArrayList<CartProductDto>());*/
		
		CartDto postedCartDto = new CartDto();
		postedCartDto.setCartStatus(false);
		postedCartDto.setCustomerName("Ilker");
		postedCartDto.setTotalAmount(2222);
		postedCartDto.setCartProductDtos(new ArrayList<CartProductDto>());
				
		
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/shopping/cart/create";

		CartDto cartDto = restTemplate.postForObject(url, postedCartDto, CartDto.class);

		//restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<CartDto>(postedCartDto), Void.class);

		return 3;
	}

	// add product to cart
	@GetMapping("/shopping/cart/add")
	@ResponseBody
	public CartProductDto addProduct() {

		CartProductDto cartProductDto = new CartProductDto();
		cartProductDto.setLineAmount(41);
		cartProductDto.setProductId(5);
		cartProductDto.setSalesPrice(32);
		cartProductDto.setSalesQuantity(3);
		cartProductDto.setCartId(2);
		
		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/shopping/cart/add";

		CartProductDto cartProduct = restTemplate.postForObject(url, cartProductDto, CartProductDto.class);

		return cartProduct;
	}

	// find cart by id
	@GetMapping("/shopping/cart/find/{cartId}")
	@ResponseBody
	public CartDto find(@PathVariable("cartId") long cartId) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/shopping/cart/find/" + cartId;

		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);

		return cartDto;
	}

	// checkout
	@GetMapping("/shopping/checkout/{cartId}")
	@ResponseBody
	public boolean checkout(@PathVariable("cartId") long cartId) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/commerce/shopping/checkout/" + cartId;

		boolean result = restTemplate.getForObject(url, Boolean.class);

		return result;
	}

}
