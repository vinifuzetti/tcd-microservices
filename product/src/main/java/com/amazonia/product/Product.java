package com.amazonia.product;

public class Product {
	
	public long id;
    public String content;

    public Product(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
