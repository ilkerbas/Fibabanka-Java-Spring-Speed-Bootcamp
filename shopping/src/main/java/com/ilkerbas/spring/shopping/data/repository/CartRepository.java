package com.ilkerbas.spring.shopping.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilkerbas.spring.shopping.data.entity.Cart;

/* Cart Repository
 * Takes Entity
 * SQL query, works with database
 * CRUD operations and custom queries
 */

public interface CartRepository extends CrudRepository<Cart, Long>{

	
}
