package com.amazonia.wishlist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WishlistController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private WishlistRepository wishlistRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewProduct (@RequestParam String name
			, @RequestParam Integer productId , @RequestParam Integer cpf) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Wishlist n = new Wishlist();
		n.setId(cpf);
		n.setName(name);
		n.setProductId(productId);
		wishlistRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Wishlist> getAllProducts() {
		// This returns a JSON or XML with the products
		return wishlistRepository.findAll();
	}
	
	@GetMapping(path="/{cpf}")
	public @ResponseBody Iterable<Wishlist> getWishList(@PathVariable Integer cpf) {
		return wishlistRepository.findByCpf(cpf);
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
