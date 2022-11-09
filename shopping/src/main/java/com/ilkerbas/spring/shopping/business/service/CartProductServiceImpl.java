package com.ilkerbas.spring.shopping.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.shopping.data.entity.CartProduct;
import com.ilkerbas.spring.shopping.data.repository.CartProductRepository;

// CartProduct Service implementation
@Service
public class CartProductServiceImpl implements CartProductService {

	// CartProductRepository, Constructor injection
	CartProductRepository cartProductRepository;
	
	public CartProductServiceImpl(CartProductRepository cartProductRepository) {
		this.cartProductRepository = cartProductRepository;
	}
	
	// delete cart product by given cartId and productId
	@Override
	public void deleteCartProduct(long cartId, long productId) {
		Optional<CartProduct> productOptional = cartProductRepository.findById(productId);
		
		if(productOptional.isPresent()) {
			CartProduct product = productOptional.get();
			cartProductRepository.delete(product);
		}
		
	}

}
