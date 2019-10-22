package com.amazonia.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/product")
public class ProductController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private ProductRepository productRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewProduct (@RequestParam String name
			, @RequestParam String category) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Product n = new Product();
		n.setName(name);
		n.setCategory(category);
		n.setViews(0);
		productRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Product> getAllProducts() {
		// This returns a JSON or XML with the products
		return productRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Product getProductId(@PathVariable Integer id) {
		
		Product n = new Product();
		n = productRepository.findById(id).get();
		Integer views = n.getViews();
		//Ao visualizar produto por id, incrementa visualizacoes
		n.setViews(views + 1);
		return productRepository.save(n);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteProductId(@PathVariable Integer id) {
		productRepository.deleteById(id);
		return;
	}
	
	@GetMapping(path="/category/{category}")
	public @ResponseBody Iterable<Product> getProductCategory(@PathVariable String category) {
		return productRepository.findByCategory(category);
	}
	
	@GetMapping(path="/views/{category}")
	public @ResponseBody Iterable<Product> getProductViewsCategory(@PathVariable String category) {
		return productRepository.findByViewsCategory(category);
	}
}
