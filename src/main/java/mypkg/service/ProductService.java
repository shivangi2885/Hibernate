package mypkg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import mypkg.entity.Product;
import mypkg.repository.ProductRepository;

@Service
//@Profile(value = {"abc", "testabc"})
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product getProductByID(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product saveProduct(Product p) {
		return repository.save(p);    //the product given to this service is then given to repository
	}                   //this repo saves the data in the connected database

	public List<Product> saveProducts(List<Product> p) {
		// TODO Auto-generated method stub
		return repository.saveAll(p);   //this is how we save multiple products in repository
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "ID of product removed is " + id;
	}

	public String updateProduct(Product p) {
		// TODO Auto-generated method stub
		Product prodInDB = repository.findById(p.getId()).orElse(null);
		if(prodInDB != null) {
			prodInDB.setName(p.getName());
			prodInDB.setPrice(p.getPrice());
			prodInDB.setQuantity(p.getQuantity());
			repository.save(prodInDB);
			return "Product details updated";
		}else {
			return "Product not found";
		}
	}

}
