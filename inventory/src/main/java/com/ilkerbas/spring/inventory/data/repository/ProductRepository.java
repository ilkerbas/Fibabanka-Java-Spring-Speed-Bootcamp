package com.ilkerbas.spring.inventory.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ilkerbas.spring.inventory.data.entity.Product;

/* Product Repository
 * Takes Entity
 * SQL query, works with database
 * CRUD operations and custom queries
 */

public interface ProductRepository extends CrudRepository<Product, Long> {

	// query for getting all products by given category id
	@Query("select p from Product p where p.category.categoryId = :categoryId")
	List<Product> findAllByCategoryId(@Param("categoryId") long categoryId);
}
