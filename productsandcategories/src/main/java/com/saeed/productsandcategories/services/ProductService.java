package com.saeed.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeed.productsandcategories.models.Category;
import com.saeed.productsandcategories.models.Product;
import com.saeed.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}
	public List<Product> productssNotIncategory(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
}
