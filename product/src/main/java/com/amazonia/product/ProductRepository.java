package com.amazonia.product;

import org.springframework.data.repository.CrudRepository;

import com.amazonia.product.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
