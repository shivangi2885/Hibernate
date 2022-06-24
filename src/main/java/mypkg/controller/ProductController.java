package mypkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mypkg.entity.Product;
import mypkg.service.ProductService;

@RestController
@Configuration
public class ProductController {
	
	public ProductService service;
	
	@Bean
	public ProductService getService() {
		this.service = new ProductService();
		return service;
	}
	
//	@Autowired
//	private ProductService service;
	
	@GetMapping("/prodById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductByID(id);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@PostMapping("/addProduct")    //this adds the data i.e. posts
	public Product addProduct(@RequestBody Product p) {
		return service.saveProduct(p);   //we send the product to be saved in service
	}
	
	//@RequestBody - example Postman (giving data from postman)
	//@Pathvariable - giving data from URL
	
	@PostMapping("/addProducts")    //this adds the data i.e. posts
	public List<Product> addProducts(@RequestBody List<Product> p) {
		return service.saveProducts(p);   //we send the product to be saved in service
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Product p) {
		return service.updateProduct(p);
	}

}
