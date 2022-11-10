package com.ilkerbas.spring.shopping.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ilkerbas.spring.shopping.business.dto.CartDto;
import com.ilkerbas.spring.shopping.business.dto.CartProductDto;
import com.ilkerbas.spring.shopping.data.entity.Cart;
import com.ilkerbas.spring.shopping.data.entity.CartProduct;
import com.ilkerbas.spring.shopping.data.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	// CartRepository, Constructor injection
	CartRepository cartRepository;
	
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	// create cart by given cartDto
	@Override
	public long create(CartDto cartDto) {
		
		Cart cart = new Cart();
		cart.setCartId(cartDto.getCartId());
		cart.setCustomerName(cartDto.getCustomerName());
		cart.setCartStatus(cartDto.isCartStatus());
		cart.setTotalAmount(cartDto.getTotalAmount());
		cart.setCartProducts(new ArrayList<CartProduct>());
		
		Cart savedCart = cartRepository.save(cart);
		
		System.out.println(savedCart.getCartId());
		
		return savedCart.getCartId();
	}

	// add cartProduct to cart by given cartProductDto
	@Override
	public CartProductDto addProduct(CartProductDto cartProductDto) {
		
		long cartId = cartProductDto.getCartId();
		
		CartProduct cartProduct = new CartProduct();
		cartProduct.setCartProductId(cartProductDto.getCartProductId());
		cartProduct.setLineAmount(cartProductDto.getLineAmount());
		cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
		cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
		cartProduct.setProductId(cartProductDto.getProductId());
		
		Optional<Cart> cartOptional = cartRepository.findById(cartId);
		
		if(cartOptional.isPresent()) {
			Cart cart = cartOptional.get();
			cartProduct.setCart(cart);
			cart.getCartProducts().add(cartProduct);
			List<CartProduct> cartProducts = cart.getCartProducts();
			cart.setCartProducts(cartProducts);
			cartRepository.save(cart);
			
			Optional<Cart> cartOpt = cartRepository.findById(cartId);
			if(cartOpt.isPresent()) {
				int sizeOfCartProducts =  cartOptional.get().getCartProducts().size();
				long cartProductId = cartOptional.get().getCartProducts().get(sizeOfCartProducts - 1).getCartProductId();
				cartProductDto.setCartProductId(cartProductId);
			}
			
			return cartProductDto;
		}
		return null;
		
	}

	// find cart by given cartId
	// return CartDto
	@Override
	public CartDto find(long cartId) {
		
		Optional<Cart> cartOptional = cartRepository.findById(cartId);
		
		if(cartOptional.isPresent()) {
			Cart cart = cartOptional.get();
			
			CartDto cartDto = new CartDto();
			cartDto.setCartId(cart.getCartId());
			cartDto.setCartStatus(cart.isCartStatus());
			cartDto.setCustomerName(cart.getCustomerName());
			cartDto.setTotalAmount(cart.getTotalAmount());
			
			List<CartProductDto> cartProductDtos = new ArrayList<>();
			Iterable<CartProduct> cartProducts = cart.getCartProducts();
			
			for(CartProduct cartProduct : cartProducts) {
				CartProductDto cartProductDto = new CartProductDto();
				cartProductDto.setCartId(cartProduct.getCart().getCartId());
				cartProductDto.setCartProductId(cartProduct.getCartProductId());
				cartProductDto.setLineAmount(cartProduct.getLineAmount());
				cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
				cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
				
				cartProductDtos.add(cartProductDto);
			}
			
			cartDto.setCartProductDtos(cartProductDtos);
			
			return cartDto;
		}
		return null;
	}

	// checkout
	@Override
	public boolean checkout(long cartId) {
		
		Optional<Cart> cartOptional = cartRepository.findById(cartId);
		
		if(cartOptional.isPresent()) {
			Cart cart = cartOptional.get();
			cart.setCartStatus(true);
			cartRepository.save(cart);
			return cart.isCartStatus();
		}
		
		return false;
	}

}
