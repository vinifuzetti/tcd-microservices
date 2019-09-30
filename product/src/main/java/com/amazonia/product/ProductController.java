package com.amazonia.product;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/product")
    public Product product(@RequestParam(value="name", defaultValue="Book") String name) {
        return new Product(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
