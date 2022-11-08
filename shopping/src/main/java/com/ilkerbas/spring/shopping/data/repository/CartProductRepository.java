package com.ilkerbas.spring.shopping.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilkerbas.spring.shopping.data.entity.CartProduct;

/* Cart Product Repository
 * Takes Entity
 * SQL query, works with database
 * CRUD operations and custom queries
 */

public interface CartProductRepository extends CrudRepository<CartProduct, Long>{

}
