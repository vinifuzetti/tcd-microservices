package com.amazia.wishlist;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wishlist {
	
	@Id
    private Integer cpf;

    private String name;

    private Integer productId;

	public Integer getId() {
		return cpf;
	}

	public void setId(Integer cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId (Integer Id) {
		this.productId = Id;
	}
}
