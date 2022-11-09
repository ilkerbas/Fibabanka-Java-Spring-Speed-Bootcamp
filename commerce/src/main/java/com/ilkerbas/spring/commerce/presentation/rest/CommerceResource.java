package com.ilkerbas.spring.commerce.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerbas.spring.commerce.business.dto.CartDto;
import com.ilkerbas.spring.commerce.business.dto.CartProductDto;
import com.ilkerbas.spring.commerce.business.dto.CategoryDto;
import com.ilkerbas.spring.commerce.business.dto.ProductDto;
import com.ilkerbas.spring.commerce.business.service.CommerceService;

@RestController
@RequestMapping("/commorce")
public class CommerceResource {

	private CommerceService commerceService;

	public CommerceResource(CommerceService commerceService) {
		this.commerceService = commerceService;
	}

	// get all categories
	@GetMapping("/inventory/categories")
	public List<CategoryDto> getAllCategories() {

		List<CategoryDto> listCategoryDtos = commerceService.findAllCategories();

		return listCategoryDtos;
	}

	// get products by given category id
	@GetMapping("inventory/products/{categoryId}")
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId) {

		List<ProductDto> productDtos = commerceService.findAllByCategoryId(categoryId);

		return productDtos;
	}

	// get product by given id
	@GetMapping("/inventory/product/{id}")
	public ProductDto getProductById(@PathVariable("id") long productId) {

		ProductDto productDto = commerceService.findProduct(productId);

		return productDto;
	}

	// delete cart product from cart
	@DeleteMapping("/commerce/shopping/cart/{cartId}/remove/{productId}")
	public String delete(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {

		commerceService.deleteCartProduct(cartId, productId);

		return "Deleted: " + productId;
	}

	// create a cart
	@GetMapping("/commerce/shopping/cart/create")
	public long create(@RequestBody CartDto cartDto) {

		commerceService.create(cartDto);

		System.out.println("Cart id: " + cartDto.getCartId() + "Customer name: " + cartDto.getCustomerName());
		return cartDto.getCartId();
	}

	// add cart product to cart
	@PostMapping("/commerce/shopping/cart/add")
	public CartProductDto add(CartProductDto cartProductDto) {

		CartProductDto productDto = commerceService.addProduct(cartProductDto);

		System.out.println(productDto.getCartProductId() + " + cartId: " + productDto.getCartId());
		return productDto;
	}

	// find cart by given id
	@GetMapping("commerce/shopping/cart/find/{cartId}")
	public CartDto find(@PathVariable("cartId") long cartId) {

		CartDto cartDto = commerceService.find(cartId);

		return cartDto;
	}

	// checkout
	@GetMapping("commerce/shopping/checkout/{cartId}")
	public Boolean checkout(@PathVariable("cartId") long cartId) {

		boolean result = commerceService.checkout(cartId);

		return result;
	}

}
