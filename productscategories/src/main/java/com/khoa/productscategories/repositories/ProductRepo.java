package com.khoa.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.khoa.productscategories.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
}
