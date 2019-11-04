package com.amazia.wishlist;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {
	
	@Query(value = "SELECT * FROM product WHERE cpf=:cpfValue", nativeQuery = true)
	public Iterable<Wishlist> findByCpf(@Param("cpfValue") Integer cpfValue);

}