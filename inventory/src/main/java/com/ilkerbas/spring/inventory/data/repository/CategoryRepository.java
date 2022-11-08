package com.ilkerbas.spring.inventory.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.ilkerbas.spring.inventory.data.entity.Category;

/* Category Repository
 * Takes Entity
 * SQL query, works with database
 * CRUD operations and custom queries
 */

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
