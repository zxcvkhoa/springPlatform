package com.khoa.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.productscategories.models.Category;
import com.khoa.productscategories.models.Product;
import com.khoa.productscategories.repositories.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product findProduct(Long productId) {
		Optional<Product> optionalProduct = productRepo.findById(productId);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	public List<Product> readAll(){
		return (List<Product>) productRepo.findAll();
	}

	public void update(Product product) {
		productRepo.save(product);
	}

	

}
