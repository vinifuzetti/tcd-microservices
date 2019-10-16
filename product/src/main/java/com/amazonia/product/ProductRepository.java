package com.amazonia.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query(value = "SELECT * FROM product where category=:categoryName", nativeQuery = true)
	public Iterable<Product> findByCategory(@Param("categoryName") String categoryName);

}
