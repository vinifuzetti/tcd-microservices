package com.amazonia.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
public class CartController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private CartRepository cartRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewProductCart (@RequestParam String name
			, @RequestParam Integer productId , @RequestParam Integer cpf
			, @RequestParam String endereco, @RequestParam Integer qtd) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Cart n = new Cart();
		n.setCpf(cpf);
		n.setProductId(productId);
		n.setEndereco(endereco);
		n.setQtd(qtd);
		cartRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Cart> getAllProductsCarts() {
		// This returns a JSON or XML with the products
		return cartRepository.findAll();
	}

}
