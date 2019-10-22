package com.amazonia.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM product WHERE category=:categoryName", nativeQuery = true)
	public Iterable<Product> findByCategory(@Param("categoryName") String categoryName);
	
	@Query(value = "SELECT * FROM product WHERE category=:categoryName ORDER BY views DESC", nativeQuery = true)
	public Iterable<Product> findByViewsCategory(@Param("categoryName") String categoryName);

}
